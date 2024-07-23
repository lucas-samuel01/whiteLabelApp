package com.lucas.whitelabelapp.domain.useCase

import android.net.Uri

interface UploadProductImageUsecase {

    suspend operator fun invoke(imageUri:Uri):String

}