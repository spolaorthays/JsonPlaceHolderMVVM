package com.thays.myapplication.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.thays.myapplication.R
import com.thays.myapplication.data.local.Photo

class RecyclerPhotosAdapter : RecyclerView.Adapter<RecyclerPhotosAdapter.PhotosViewHolder>() {

    var listPhotos = mutableListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.photo_item,
            parent,
            false
        )
        return PhotosViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photo = listPhotos[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int = listPhotos.size

    fun updatePhotos(photoList: List<Photo>) {
        listPhotos.addAll(photoList)
        notifyDataSetChanged()
    }

    inner class PhotosViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var image = view.findViewById<ImageView>(R.id.imagePhoto)
        private var id = view.findViewById<TextView>(R.id.idPhoto)
        private var title = view.findViewById<TextView>(R.id.titlePhoto)

        fun bind(photo: Photo) {
            Picasso.get().load(photo.url).into(image)

            id.text = photo.id.toString()
            title.text = photo.title
        }
    }

}