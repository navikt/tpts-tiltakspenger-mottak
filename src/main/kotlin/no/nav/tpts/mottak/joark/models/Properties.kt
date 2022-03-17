package no.nav.tpts.mottak.joark.models

import kotlinx.serialization.Serializable
import no.nav.tpts.mottak.databind.LocalDateSerializer
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
    val erIEndreStatus: String? = null,
    val etternavn: String = "",
    val fnr: String? = null,
    @Serializable(with = LocalDateSerializer::class) val fom: LocalDate? = null,
    val fornavn: String = "",
    val gjeldendeAdresse: String? = null,
    val gjeldendeAdresseGyldigFra: String? = null,
    val gjeldendeAdresseGyldigTil: String? = null,
    val gjeldendeAdresseLandkode: String? = null,
    val gjeldendeAdresseType: String? = null,
    val harSluttdatoFraArena: String? = null,
    val kjonn: String? = null,
    val kontonummer: String? = null,
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
    val statsborgerskapType: String? = null,
    val tilleggsopplysninger: String? = null,
    val tiltaksliste: String? = null,
    @Serializable(with = LocalDateSerializer::class) val tom: LocalDate? = null,
    val trygdogpensjon: String? = null,
    val utenlandskKontoBanknavn: String? = null,
    val utenlandskKontoLand: String? = null,
)
