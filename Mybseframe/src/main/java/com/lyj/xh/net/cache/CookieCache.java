package com.lyj.xh.net.cache;

import java.util.Collection;

import okhttp3.Cookie;

/**
 * Created by lyj on 2017/3/27 0027.
 */

public interface CookieCache extends Iterable<Cookie> {

    /**
     * Add all the new cookies to the session, existing cookies will be overwritten.
     *
     * @param cookies
     */
    void addAll(Collection<Cookie> cookies);

    /**
     * Clear all the cookies from the session.
     */
    void clear();
}
