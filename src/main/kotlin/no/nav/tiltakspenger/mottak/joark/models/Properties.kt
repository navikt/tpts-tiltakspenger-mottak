package no.nav.tiltakspenger.mottak.joark.models

import kotlinx.serialization.Serializable
import no.nav.tiltakspenger.mottak.databind.LocalDateSerializer
import no.nav.tiltakspenger.mottak.databind.StringBooleanSerializer
import java.time.LocalDate

@Serializable
data class Properties(
    val arenaId: String? = null,
    val arrangoer: String? = null,
    val adresse: String? = null,
    val alder: String? = null,
    val antallDager: String? = null,
    val arrangoernavn: String? = null,
    val barnetillegg: String? = null,
    val diskresjonskode: String? = null,
    val epost: String? = null,
    val erUtenlandskBankkonto: String? = null,
    @Serializable(with = StringBooleanSerializer::class) val erIEndreStatus: Boolean? = null,
    val etternavn: String? = null,
    val fnr: String? = null,
    @Serializable(with = LocalDateSerializer::class) val fom: LocalDate? = null,
    val fornavn: String? = null,
    val gjeldendeAdresse: String? = null,
    val gjeldendeAdresseGyldigFra: String? = null,
    val gjeldendeAdresseGyldigTil: String? = null,
    val gjeldendeAdresseLandkode: String? = null,
    val gjeldendeAdresseType: String? = null,
    @Serializable(with = StringBooleanSerializer::class) val harSluttdatoFraArena: Boolean? = null,
    val kjonn: String? = null,
    val kommune: String? = null,
    val kontonummer: String? = null,
    val land: String? = null,
    val mellomnavn: String? = null,
    val navn: String? = null,
    val personalia: String? = null,
    val postnummer: String? = null,
    @Serializable(with = LocalDateSerializer::class) val opprinneligstartdato: LocalDate? = null,
    @Serializable(with = LocalDateSerializer::class) val opprinneligsluttdato: LocalDate? = null,
    val sekundarAdresse: String? = null,
    val sekundarAdresseGyldigFra: String? = null,
    val sekundarAdresseGyldigTil: String? = null,
    val sekundarAdresseType: String? = null,
    val statsborgerskap: String? = null,
    @Serializable(with = LocalDateSerializer::class) val startdato: LocalDate? = null,
    @Serializable(with = LocalDateSerializer::class) val sluttdato: LocalDate? = null,
    @Serializable(with = StringBooleanSerializer::class) val sokerbarnetillegg: Boolean? = null,
    val statsborgerskapType: String? = null,
    val tilleggsopplysninger: String? = null,
    val tiltaksliste: String? = null,
    @Serializable(with = LocalDateSerializer::class) val tom: LocalDate? = null,
    val trygdogpensjon: String? = null,
    val utenlandskKontoBanknavn: String? = null,
    val utenlandskKontoLand: String? = null,
)
