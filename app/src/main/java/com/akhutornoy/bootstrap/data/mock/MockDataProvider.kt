package com.akhutornoy.bootstrap.data.mock

import com.akhutornoy.bootstrap.R
import kotlin.random.Random

class MockDataProvider {

    private val random = Random(12)

    private val picResIds = listOf(
        R.drawable.mock_leaves_sepia,
        R.drawable.mock_mounteen,
        R.drawable.mock_rouse,
        R.drawable.mock_tunnel
    )

    private fun getPic(): Int {
        val index = random.nextInt(0, picResIds.size - 1)
        return picResIds[index]
    }

    fun getPictureResId(): Int = getPic()

}