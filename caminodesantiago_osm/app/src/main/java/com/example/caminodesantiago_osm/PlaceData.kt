package com.example.caminodesantiago_osm

import org.osmdroid.util.GeoPoint

data class Place(
    val id: String,
    val title: String,
    val description: String,
    val geoPoint: GeoPoint,
    val drawableName: String
)

object PlaceData {
    val PLACES = listOf(
        Place(
            id = "sjpp",
            title = "Saint-Jean-Pied-de-Port",
            description = "Традиционный старт Пути: старинный пограничный город в Пиренеях, где паломники готовятся к переходу через горы.",
            geoPoint = GeoPoint(43.1630, -1.2379),
            drawableName = "sjpp"
        ),
        Place(
            id = "roncesvalles",
            title = "Roncesvalles",
            description = "Знаменитое место с монастырём и историей сражений; первая ночёвка многих паломников уже в Испании.",
            geoPoint = GeoPoint(42.9796, -1.2500),
            drawableName = "roncesvalles"
        ),
        Place(
            id = "pamplona",
            title = "Pamplona",
            description = "Город с богатой историей и ярким праздником Сан-Фермин; важная прослойка маршрута — старые кварталы и стены.",
            geoPoint = GeoPoint(42.8125, -1.6458),
            drawableName = "pamplona"
        ),
        Place(
            id = "logrono",
            title = "Logroño",
            description = "Столица региона Риоха — винный регион; популярная остановка для отдыха и дегустации.",
            geoPoint = GeoPoint(42.4627, -2.4456),
            drawableName = "logrono"
        ),
        Place(
            id = "burgos",
            title = "Burgos",
            description = "Готический собор Бургоса — архитектурное сокровище; важный культурный пункт пути.",
            geoPoint = GeoPoint(42.34399, -3.69691),
            drawableName = "burgos"
        ),
        Place(
            id = "leon",
            title = "León",
            description = "Город с великолепным собором и старинными улицами — классическая остановка перед финалом.",
            geoPoint = GeoPoint(42.5987, -5.5671),
            drawableName = "leon"
        ),
        Place(
            id = "santiago",
            title = "Santiago de Compostela",
            description = "Финальная цель: Кафедральный собор Святого Иакова — конец паломничества и его смысл.",
            geoPoint = GeoPoint(42.8806, -8.5456),
            drawableName = "santiago"
        )
    )
}
