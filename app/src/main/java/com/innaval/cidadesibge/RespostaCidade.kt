package com.innaval.cidadesibge

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class RespostaCidade(
    @SerializedName("municipio") val municipio: List<Cidade>
):Parcelable