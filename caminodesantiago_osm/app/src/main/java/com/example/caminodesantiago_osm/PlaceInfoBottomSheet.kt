package com.example.caminodesantiago_osm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PlaceInfoBottomSheet : BottomSheetDialogFragment() {

    companion object {
        private const val ARG_TITLE = "arg_title"
        private const val ARG_DESC = "arg_desc"
        private const val ARG_DRAWABLE = "arg_drawable"

        fun newInstance(title: String, desc: String, drawableName: String): PlaceInfoBottomSheet {
            val b = Bundle()
            b.putString(ARG_TITLE, title)
            b.putString(ARG_DESC, desc)
            b.putString(ARG_DRAWABLE, drawableName)
            val f = PlaceInfoBottomSheet()
            f.arguments = b
            return f
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bs_place_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString(ARG_TITLE) ?: ""
        val desc = arguments?.getString(ARG_DESC) ?: ""
        val drawableName = arguments?.getString(ARG_DRAWABLE) ?: ""

        val iv = view.findViewById<ImageView>(R.id.place_image)
        val tvTitle = view.findViewById<TextView>(R.id.place_title)
        val tvDesc = view.findViewById<TextView>(R.id.place_description)

        tvTitle.text = title
        tvDesc.text = desc

        // Получаем ID drawable по имени и ставим в ImageView
        val resId = resources.getIdentifier(drawableName, "drawable", requireContext().packageName)
        if (resId != 0) {
            iv.setImageResource(resId)
        } else {
            iv.setImageResource(android.R.drawable.ic_menu_report_image)
        }
    }
}
