package com.lyj.xh.net.cookie;

import com.lyj.xh.net.cache.CookieCache;
import com.lyj.xh.net.cache.CookiePersistor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.HttpUrl;

/**
 * Created by lyj on 2017/3/27 0027.
 */

public class NovateCookieManager implements ClearableCookieJar {
    private CookieCache cache;
    private CookiePersistor persistor;

    public NovateCookieManager(CookieCache cache, CookiePersistor persistor) {
        this.cache = cache;
        this.persistor = persistor;

        this.cache.addAll(persistor.loadAll());
    }

    @Override
    synchronized public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        cache.addAll(cookies);
        persistor.saveAll(filterPersistentCookies(cookies));
    }

    private static List<Cookie> filterPersistentCookies(List<Cookie> cookies) {
        List<Cookie> persistentCookies = new ArrayList<>();

        for (Cookie cookie : cookies) {
            if (cookie.persistent()) {
                persistentCookies.add(cookie);
            }
        }
        return persistentCookies;
    }

    @Override
    synchronized public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookiesToRemove = new ArrayList<>();
        List<Cookie> validCookies = new ArrayList<>();

        for (Iterator<Cookie> it = cache.iterator(); it.hasNext(); ) {
            Cookie currentCookie = it.next();

            if (isCookieExpired(currentCookie)) {
                cookiesToRemove.add(currentCookie);
                it.remove();

            } else if (currentCookie.matches(url)) {
                validCookies.add(currentCookie);
            }
        }

        persistor.removeAll(cookiesToRemove);

        return validCookies;
    }

    private static boolean isCookieExpired(Cookie cookie) {
        return cookie.expiresAt() < System.currentTimeMillis();
    }

    @Override
    synchronized public void clearSession() {
        cache.clear();
        cache.addAll(persistor.loadAll());
    }

    @Override
    synchronized public void clear() {
        cache.clear();
        persistor.clear();
    }



}
