package com.mt.tapestry.data.entity

import org.simpleframework.xml.ElementList

/**
 * Created by m_toskhoparan on 08-May-17.
 */

data class Channel (
        @field:ElementList(entry = "item", inline = true, required = false)
        var feeds: MutableList<Feed> = ArrayList()
)