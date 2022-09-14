package no.nav.tiltakspenger.mottak.søknad

import mu.KotlinLogging
import no.nav.tiltakspenger.mottak.clients.saf.SafClient

private val LOG = KotlinLogging.logger {}
private val SECURELOG = KotlinLogging.logger("tjenestekall")

suspend fun handleSøknad(journalpostId: String): Søknad? {
    LOG.info { "Retrieving journalpost metadata with journalpostId $journalpostId" }
    val journalfortDokumentMetaData = SafClient.hentMetadataForJournalpost(journalpostId)
    if (journalfortDokumentMetaData != null) {
        LOG.info { "Retrieving søknad with dokumentInfoId ${journalfortDokumentMetaData.dokumentInfoId}" }
        val json = SafClient.hentSoknad(journalfortDokumentMetaData)
        LOG.info {
            "Retrieved søknad with dokumentInfoId ${journalfortDokumentMetaData.dokumentInfoId}, " +
                    "se secure-log for details"
        }
        SECURELOG.info { "Retrieved søknad $json" }
        //        PersonQueries.insertIfNotExists(søknad.ident, søknad.fornavn, søknad.etternavn)
//        val dokumentInfoId = journalfortDokumentMetaData.dokumentInfoId?.toInt()
//        checkNotNull(dokumentInfoId) { "Missing dokumentInfoId for søknad" }
//        SøknadQueries.insertIfNotExists(
//            journalpostId.toInt(),
//            dokumentInfoId,
//            json,
//            søknad
//        )
        // Can not be inserted before soknad exists
//        søknad.barnetillegg.map {
//            BarnetilleggQueries.insertBarnetillegg(
//                barnetillegg = it,
//                journalpostId = journalpostId.toInt(),
//                dokumentInfoId = dokumentInfoId
//            )
//        }
        return Søknad.fromJson(json, journalpostId, journalfortDokumentMetaData.dokumentInfoId)
    } else {
        LOG.info { "Journalpost with ID $journalpostId was not handled" }
        return null
    }
}
