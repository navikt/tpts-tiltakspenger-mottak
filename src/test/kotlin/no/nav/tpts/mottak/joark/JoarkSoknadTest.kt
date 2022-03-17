package no.nav.tpts.mottak.joark

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import no.nav.tpts.mottak.joark.models.JoarkSoknad
import no.nav.tpts.mottak.soknad.SoknadDetails
import no.nav.tpts.mottak.soknad.soknadList.Soknad
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import java.time.LocalDate

class JoarkSoknadTest {

    private val json = Json { ignoreUnknownKeys = true }

    @Test
    fun `should put joark faktum data into soknad object`() {
        val faktums = this::class.java.classLoader.getResource("faktumsSkjermet.json")!!.readText()
        val joarkSoknad = json.decodeFromString<JoarkSoknad>(faktums)
        SoknadDetails.fromJoarkSoknad(joarkSoknad).also {
            assertEquals("BRÅKETE", it.fornavn)
            assertEquals("BLYANT", it.etternavn)
            assertEquals("14038205537", it.fnr)
            assertEquals("136950219", it.tiltak?.id)
            assertEquals("2022-03-10T10:03:35.365", it.opprettet.toString())
            assertEquals("Arbeidsrettet rehabilitering (dag)", it.tiltak?.navn)
            assertEquals("AVONOVA HELSE AS", it.tiltak?.arrangoer)
            assertEquals("2022-03-10", it.tiltak?.opprinneligStartdato.toString())
            assertEquals(null, it.tiltak?.opprinneligSluttdato?.toString())
        }
    }

    @Test
    fun `should put brukerregistrert start and sluttdato in soknad`() {
        val soknad = this::class.java.classLoader.getResource("brukerregistrert_soknad.json")!!.readText()
        Soknad.fromJoarkSoknad(soknad).also {
            assertEquals("STERK", it.fornavn)
            assertEquals("LAPP", it.etternavn)
            assertEquals(LocalDate.parse("2022-03-01"), it.brukerRegistrertStartDato)
            assertEquals(LocalDate.parse("2022-03-31"), it.brukerRegistrertSluttDato)
            assertNull(it.systemRegistrertStartDato)
            assertNull(it.systemRegistrertSluttDato)
        }
    }
}
