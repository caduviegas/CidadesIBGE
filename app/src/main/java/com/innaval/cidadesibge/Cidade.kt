package com.innaval.cidadesibge

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Cidade(
    @SerializedName("nome") val nome: List<String>
): Parcelable
