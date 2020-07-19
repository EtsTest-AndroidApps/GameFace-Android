/*
 * Copyright (c) 2020 - Magnitude Studios - All Rights Reserved
 * Unauthorized copying of this file, via any medium is prohibited
 * All software is proprietary and confidential
 *
 */

package com.magnitudestudios.GameFace

import android.widget.ImageButton
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun RequestManager.loadProfile(url: String, target: ImageButton) {
    if (url.isEmpty()) {
        this.load(R.drawable.ic_add_profile_pic).into(target)
        return
    }
    this.load(url)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .placeholder(R.drawable.profile_placeholder)
            .error(R.drawable.ic_add_profile_pic)
            .transition(DrawableTransitionOptions.withCrossFade())
            .circleCrop()
            .into(target)
}

fun RequestManager.loadProfile(url: String, target: ImageView) {
    if (url.isEmpty()) {
        this.load(R.drawable.ic_user_placeholder).into(target)
        return
    }
    this.load(url)
            .error(R.drawable.ic_user_placeholder)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(R.drawable.profile_placeholder)
            .circleCrop()
            .into(target)
}