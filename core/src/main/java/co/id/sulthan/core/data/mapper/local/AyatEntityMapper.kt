package co.id.sulthan.core.data.mapper.local

import co.id.sulthan.core.data.mapper.BaseMapper
import co.id.sulthan.core.data.source.local.entity.AyatEntity
import co.id.sulthan.core.domain.model.Ayat

class AyatEntityMapper : BaseMapper<AyatEntity, Ayat> {
    override fun mapToDomain(model: AyatEntity): Ayat {
        return Ayat(
            model.ar,
            model.id,
            model.nomor,
            model.tr
        )
    }

    override fun mapToModel(domain: Ayat): AyatEntity {
        return AyatEntity(
            domain.ar,
            domain.id,
            domain.nomor,
            domain.tr
        )
    }
}