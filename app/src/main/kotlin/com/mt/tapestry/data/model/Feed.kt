package com.mt.tapestry.data.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Path

/**
 * Created by m_toskhoparan on 08-May-17.
 */

@Entity
class Feed {
    @PrimaryKey
    @field:Element(required = false)
    var title: String = ""

    @field:Element(required = false)
    var description: String = ""

    @field:Element(required = false)
    var link: String = ""

    @field:Element(required = false)
    @ColumnInfo(name = "pub_date")
    var pubDate: String = ""

    @field:Attribute(required = false)
    @field:Path("media:thumbnail")
    var url: String = ""

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Feed

        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        return title.hashCode()
    }
}

// todo data class is not allowed here,
// because xml persister requires an empty constructor,
// but Room framework can't detect the right constructor