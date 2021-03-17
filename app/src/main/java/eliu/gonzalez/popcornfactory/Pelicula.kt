package eliu.gonzalez.popcornfactory

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import java.io.Serializable

data class Pelicula(var titulo: String,
                    var image: Int,
                    var header: Int,
                    var sinopsis: String,
                    var seats:ArrayList<Client>): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        ArrayList<Client>().apply { parcel.readList(this,Client::class.java.classLoader) }

    )

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeInt(image)
        parcel.writeInt(header)
        parcel.writeString(sinopsis)
        parcel.writeList(seats)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pelicula> {
        override fun createFromParcel(parcel: Parcel): Pelicula {
            return Pelicula(parcel)
        }

        override fun newArray(size: Int): Array<Pelicula?> {
            return arrayOfNulls(size)
        }
    }
}

