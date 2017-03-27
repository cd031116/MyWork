package com.lyj.xh.net.cookie;

import okhttp3.CookieJar;

/**
 * Created by lyj on 2017/3/27 0027.
 */

public interface ClearableCookieJar extends CookieJar {

    /**
     * Clear all the session cookies while maintaining the persisted ones.
     */
    void clearSession();

    /**
     * Clear all the cookies from persistence and from the cache.
     */
    void clear();
}
