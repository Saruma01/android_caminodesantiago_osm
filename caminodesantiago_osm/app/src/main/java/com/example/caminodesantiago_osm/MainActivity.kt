package com.example.caminodesantiago_osm

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Polyline

class MainActivity : AppCompatActivity() {

    private lateinit var map: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Конфигурация osmdroid (убрали PreferenceManager — используем только userAgent)
        Configuration.getInstance().userAgentValue = applicationContext.packageName

        setContentView(R.layout.activity_main)

        map = findViewById(R.id.map)
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)

        val mapController = map.controller
        mapController.setZoom(6.5)
        mapController.setCenter(PlaceData.PLACES.first().geoPoint) // убрали каст

        // Добавление маркеров и сбор точек для маршрута
        val overlays = map.overlays
        val polyPoints = ArrayList<GeoPoint>()
        val markerToPlace = mutableMapOf<Marker, Place>()

        for (place in PlaceData.PLACES) {
            val marker = Marker(map)
            marker.position = place.geoPoint
            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
            marker.title = place.title

            // Клик по маркеру
            marker.setOnMarkerClickListener { m, _ ->
                val p = markerToPlace[m]
                if (p != null) {
                    val bs = PlaceInfoBottomSheet.newInstance(p.title, p.description, p.drawableName)
                    bs.show(supportFragmentManager, "place_info")
                    true
                } else {
                    false
                }
            }

            overlays.add(marker)
            markerToPlace[marker] = place
            polyPoints.add(place.geoPoint)
        }

        // Рисуем полилинию маршрута
        val polyline = Polyline().apply {
            setPoints(polyPoints)
            width = 8f
            color = Color.parseColor("#FF5722") // можно заменить на ContextCompat.getColor(...)
        }
        overlays.add(polyline)
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }
}
