package com.mt.tapestry.data.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

/**
 * Created by m_toskhoparan on 08-May-17.
 */

@Root
data class RSS (
        @field:Element var channel: Channel? = null
)