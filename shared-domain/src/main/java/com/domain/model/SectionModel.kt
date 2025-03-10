package com.domain.model

import com.vro.constants.EMPTY_STRING

sealed class SectionModel(
    open val id: String,
    open val sectionType: SectionType,
    open val sectionSubtype: SectionSubtype,
) {
    sealed class ParagraphSection(
        override val id: String,
        open val model: ParagraphSectionModel,
        override val sectionType: SectionType = SectionType.PARAGRAPH,
        override val sectionSubtype: SectionSubtype,
    ) : SectionModel(id, sectionType, sectionSubtype) {
        data class Paragraph(
            override val id: String = EMPTY_STRING,
            override val model: ParagraphSectionModel = ParagraphSectionModel(),
            override val sectionSubtype: SectionSubtype = SectionSubtype.PARAGRAPH,
        ) : ParagraphSection(model = model, sectionSubtype = sectionSubtype, id = id)
    }

    sealed class RestaurantSection(
        override val id: String,
        open val model: RestaurantSectionModel,
        override val sectionType: SectionType = SectionType.RESTAURANT,
        override val sectionSubtype: SectionSubtype,
    ) : SectionModel(id, sectionType, sectionSubtype) {
        class TopLeftImage(
            override val id: String = EMPTY_STRING,
            override val model: RestaurantSectionModel = RestaurantSectionModel(),
            override val sectionSubtype: SectionSubtype = SectionSubtype.RESTAURANT_TOP_LEFT,
        ) : RestaurantSection(model = model, sectionSubtype = sectionSubtype, id = id)

        class TopRightImage(
            override val id: String = EMPTY_STRING,
            override val model: RestaurantSectionModel = RestaurantSectionModel(),
            override val sectionSubtype: SectionSubtype = SectionSubtype.RESTAURANT_TOP_RIGHT,
        ) : RestaurantSection(model = model, sectionSubtype = sectionSubtype, id = id)

        class TopImage(
            override val id: String = EMPTY_STRING,
            override val model: RestaurantSectionModel = RestaurantSectionModel(),
            override val sectionSubtype: SectionSubtype = SectionSubtype.RESTAURANT_TOP,
        ) : RestaurantSection(model = model, sectionSubtype = sectionSubtype, id = id)

        class BottomImage(
            override val id: String = EMPTY_STRING,
            override val model: RestaurantSectionModel = RestaurantSectionModel(),
            override val sectionSubtype: SectionSubtype = SectionSubtype.RESTAURANT_BOTTOM,
        ) : RestaurantSection(model = model, sectionSubtype = sectionSubtype, id = id)
    }

    sealed class BulletSection(
        override val id: String,
        open val model: BulletSectionModel,
        override val sectionType: SectionType = SectionType.BULLET,
        override val sectionSubtype: SectionSubtype,
    ) : SectionModel(id, sectionType, sectionSubtype) {
        data class Bullet(
            override val id: String = EMPTY_STRING,
            override val model: BulletSectionModel = BulletSectionModel(),
            override val sectionSubtype: SectionSubtype = SectionSubtype.BULLET,
        ) : BulletSection(model = model, sectionSubtype = sectionSubtype, id = id)

        data class BulletTitle(
            override val id: String = EMPTY_STRING,
            override val model: BulletSectionModel = BulletSectionModel(),
            override val sectionSubtype: SectionSubtype = SectionSubtype.BULLET_TITLE,
        ) : BulletSection(model = model, sectionSubtype = sectionSubtype, id = id)
    }

    sealed class ImageSection(
        override val id: String,
        open val model: ImageSectionModel,
        override val sectionType: SectionType = SectionType.IMAGE,
        override val sectionSubtype: SectionSubtype,
    ) : SectionModel(id, sectionType, sectionSubtype) {
        data class ImageFull(
            override val id: String = EMPTY_STRING,
            override val model: ImageSectionModel = ImageSectionModel(),
            override val sectionSubtype: SectionSubtype = SectionSubtype.IMAGE,
        ) : ImageSection(model = model, sectionSubtype = sectionSubtype, id = id)

        data class CardCarousel(
            override val id: String = EMPTY_STRING,
            override val model: ImageSectionModel = ImageSectionModel(),
            override val sectionSubtype: SectionSubtype = SectionSubtype.IMAGE_CARD_CAROUSEL,
        ) : ImageSection(model = model, sectionSubtype = sectionSubtype, id = id)
    }

    sealed class InfoSection(
        override val id: String,
        open val model: InfoSectionModel = InfoSectionModel(),
        override val sectionType: SectionType = SectionType.INFO,
        override val sectionSubtype: SectionSubtype,
    ) : SectionModel(id, sectionType, sectionSubtype) {
        data class InfoBox(
            override val id: String = EMPTY_STRING,
            override val model: InfoSectionModel = InfoSectionModel(),
            override val sectionSubtype: SectionSubtype = SectionSubtype.INFO_BOX,
        ) : InfoSection(sectionSubtype = sectionSubtype, id = id)

        data class InfoCard(
            override val id: String = EMPTY_STRING,
            override val model: InfoSectionModel = InfoSectionModel(),
            override val sectionSubtype: SectionSubtype = SectionSubtype.INFO_CARD,
        ) : InfoSection(sectionSubtype = sectionSubtype, id = id)
    }

    sealed class RouteSection(
        override val id: String,
        open val model: RouteSectionModel,
        override val sectionType: SectionType = SectionType.ROUTE,
        override val sectionSubtype: SectionSubtype,
    ) : SectionModel(id, sectionType, sectionSubtype) {
        data class Route(
            override val id: String = EMPTY_STRING,
            override val model: RouteSectionModel = RouteSectionModel(),
            override val sectionSubtype: SectionSubtype = SectionSubtype.ROUTE,
        ) : RouteSection(model = model, sectionSubtype = sectionSubtype, id = id)

        data class RouteHorizontal(
            override val id: String = EMPTY_STRING,
            override val model: RouteSectionModel = RouteSectionModel(),
            override val sectionSubtype: SectionSubtype = SectionSubtype.ROUTE_HORIZONTAL,
        ) : RouteSection(model = model, sectionSubtype = sectionSubtype, id = id)
    }

    enum class SectionType(val value: String) {
        PARAGRAPH("PARAGRAPH"),
        RESTAURANT("RESTAURANT"),
        BULLET("BULLET"),
        IMAGE("IMAGE"),
        INFO("INFO"),
        ROUTE("ROUTE")
    }

    enum class SectionSubtype(val value: String) {
        BULLET_TITLE("BULLET_TITLE"),
        BULLET("BULLET"),
        PARAGRAPH("PARAGRAPH"),
        RESTAURANT_TOP_LEFT("RESTAURANT_TOP_LEFT"),
        RESTAURANT_TOP_RIGHT("RESTAURANT_TOP_RIGHT"),
        RESTAURANT_TOP("RESTAURANT_TOP"),
        RESTAURANT_BOTTOM("RESTAURANT_BOTTOM"),
        IMAGE("IMAGE"),
        IMAGE_CARD_CAROUSEL("IMAGE_CARD_CAROUSEL"),
        INFO_BOX("INFO_BOX"),
        INFO_CARD("INFO_CARD"),
        ROUTE("ROUTE"),
        ROUTE_HORIZONTAL("ROUTE_HORIZONTAL"),
    }
}