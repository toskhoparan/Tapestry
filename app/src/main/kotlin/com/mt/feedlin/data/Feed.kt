package com.mt.feedlin.data

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Path

/**
 * Created by m_toskhoparan on 08-May-17.
 */

data class Feed (
        @field:Element(required = false) var title: String? = null,
        @field:Element(required = false) var description: String? = null,
        @field:Element(required = false) var link: String? = null,
        @field:Element(required = false) var pubDate: String? = null,
        @field:Attribute(required = false) @field:Path("media:thumbnail") var url: String? = null
)