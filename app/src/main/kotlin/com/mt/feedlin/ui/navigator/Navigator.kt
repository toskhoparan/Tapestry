package com.mt.feedlin.ui.navigator

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import com.mt.feedlin.R
import com.mt.feedlin.data.Feed
import javax.inject.Inject

/**
 * Created by max on 12-May-17.
 */

class Navigator @Inject constructor(val context: Context) : BaseNavigator {

    companion object {
        const val MIME_TEXT = "text/plain"
    }

    override fun shareFeed(feed: Feed) {
        val shareText = feed.title + "\n\n" + feed.link + "\n\n" + context.getString(R.string.copyright)

        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.type = MIME_TEXT
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareText)

        val chooserIntent = Intent.createChooser(sendIntent, context.getString(R.string.share_title))
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        ContextCompat.startActivity(context, chooserIntent, null)
    }
}