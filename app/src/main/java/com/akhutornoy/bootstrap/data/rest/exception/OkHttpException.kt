package com.akhutornoy.bootstrap.data.rest.exception

import java.io.IOException

class OkHttpException(error: IOException): IOException(error)