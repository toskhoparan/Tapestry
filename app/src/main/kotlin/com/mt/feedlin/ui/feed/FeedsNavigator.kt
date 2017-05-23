package com.mt.feedlin.ui.feed

import android.content.Intent
import com.mt.feedlin.R
import com.mt.feedlin.data.Feed
import javax.inject.Inject

/**
 * Created by max on 12-May-17.
 */

class FeedsNavigator @Inject constructor(val activity: FeedsActivity) : FeedsContract.Navigator {

    companion object {
        const val MIME_TEXT = "text/plain"
    }

    override fun shareFeed(feed: Feed) {
        val shareText = feed.title + "\n\n" + feed.link + "\n\n" + activity.getString(R.string.copyright)

        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.type = MIME_TEXT
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareText)

        val chooserIntent = Intent.createChooser(sendIntent, activity.getString(R.string.share_title))

        activity.startActivity(chooserIntent)
    }
}