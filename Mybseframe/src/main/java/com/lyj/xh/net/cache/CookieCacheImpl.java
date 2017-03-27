package com.lyj.xh.net.cache;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import okhttp3.Cookie;

/**
 * Created by lyj on 2017/3/27 0027.
 */

public class CookieCacheImpl implements CookieCache {

    private Set<IdentifiableCookie> cookies;

    public CookieCacheImpl() {
        cookies = new HashSet<>();
    }

    @Override
    public void addAll(Collection<Cookie> newCookies) {
        for (IdentifiableCookie cookie : IdentifiableCookie.decorateAll(newCookies)) {
            this.cookies.remove(cookie);
            this.cookies.add(cookie);
        }
    }

    @Override
    public void clear() {
        cookies.clear();
    }

    @Override
    public Iterator<Cookie> iterator() {
        return new SetCookieCacheIterator();
    }

    private class SetCookieCacheIterator implements Iterator<Cookie> {

        private Iterator<IdentifiableCookie> iterator;

        public SetCookieCacheIterator() {
            iterator = cookies.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Cookie next() {
            return iterator.next().getCookie();
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }
}
