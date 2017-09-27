package com.mt.tapestry.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by m_toskhoparan on 09/27/17.
 */
data class RxSchedulers(val disk: Scheduler = Schedulers.single(),
                        val network: Scheduler = Schedulers.io(),
                        val main: Scheduler = AndroidSchedulers.mainThread())