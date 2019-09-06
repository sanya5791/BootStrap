package com.akhutornoy.bootstrap.usecase

import com.akhutornoy.bootstrap.data.Repository
import javax.inject.Inject

class GetMockPictureUseCase @Inject constructor(
    private val repository: Repository
) : BaseUseCase<Int, Unit>() {

    override suspend fun getResult(params: Unit): Int {
        return repository.getMockPictureResId()
    }

}