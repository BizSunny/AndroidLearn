package com.example.twelfth.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.twelfth.R

data class Days(
    @StringRes val day: Int,
    @StringRes val dayDescriptor: Int,
    @DrawableRes val dayImage: Int,
    @StringRes val dayContent: Int
)

val dayList = listOf(
    Days(R.string.title1, R.string.description1, R.drawable.image1, R.string.content1),
    Days(R.string.title2, R.string.description2, R.drawable.image2, R.string.content2),
    Days(R.string.title3, R.string.description3, R.drawable.image3, R.string.content3),
    Days(R.string.title4, R.string.description4, R.drawable.image4, R.string.content4),
    Days(R.string.title5, R.string.description5, R.drawable.image5, R.string.content5),
    Days(R.string.title6, R.string.description6, R.drawable.image6, R.string.content6),
    Days(R.string.title7, R.string.description7, R.drawable.image7, R.string.content7),
    Days(R.string.title8, R.string.description8, R.drawable.image8, R.string.content8),
    Days(R.string.title9, R.string.description9, R.drawable.image9, R.string.content9),
    Days(R.string.title10, R.string.description10, R.drawable.image10, R.string.content10),
    Days(R.string.title11, R.string.description11, R.drawable.image11, R.string.content11),
    Days(R.string.title12, R.string.description12, R.drawable.image12, R.string.content12),
    Days(R.string.title13, R.string.description13, R.drawable.image13, R.string.content13),
    Days(R.string.title14, R.string.description14, R.drawable.image14, R.string.content14),
    Days(R.string.title15, R.string.description15, R.drawable.image15, R.string.content15),
)