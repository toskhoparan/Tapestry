package com.mt.tapestry.ui.feed

import android.content.Intent
import android.net.Uri
import com.mt.tapestry.R
import com.mt.tapestry.data.model.Feed
import com.mt.tapestry.injection.scope.ActivityScope
import javax.inject.Inject

/**
 * Created by max on 12-May-17.
 */

@ActivityScope
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

    override fun openLink(link: String?) {
        activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
    }
}