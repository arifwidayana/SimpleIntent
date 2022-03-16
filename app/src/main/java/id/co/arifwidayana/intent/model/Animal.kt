package id.co.arifwidayana.intent.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Animal(val name: String, val color: String, val legs: Int, val environment: String): Parcelable
