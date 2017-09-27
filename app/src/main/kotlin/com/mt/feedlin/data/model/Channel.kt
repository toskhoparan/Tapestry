package com.mt.feedlin.data.model

import org.simpleframework.xml.ElementList

/**
 * Created by m_toskhoparan on 08-May-17.
 */

data class Channel (
        @field:ElementList(entry = "item", inline = true, required = false)
        var feeds: MutableList<Feed> = ArrayList()
)