# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 

# Krav til innlevering

Se oblig-tekst for alle krav. Oppgaver som ikke oppfyller følgende vil ikke få godkjent:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* Ingen debug-utskrifter
* Alle testene som kreves fungerer (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet

# Arbeidsfordeling

Oppgaven er levert av følgende student:
* Khalid Ahmed Farah, s341843, s341843@oslomet.no

Jeg har brukt git til å dokumentere arbeidet mitt som har ledet til et total av 43 commits med logg-melding der det
beskrives hva jeg gjorde eller hvilken oppgaven jeg startet på.

arbeidsfordeling ble da at jeg gjord alle oppgaver fra 0 - 8.

# Beskrivelse av oppgaveløsning (maks 5 linjer per oppgave)

For alle oppgavene kjørte jeg gjennom egne tester og DobbeltLenketListeTest (dersom jeg ikke nevner det under).

* Oppgave 1:
For oppgave 1 tok jeg inspiasjon fra ukesoppgavene for boolean tom ved å bare returnere antall == 0, mens for antall
returnerte jeg bare antall. Deretter startet jeg med konstruktrøren der jeg da brukte en for løkke for å kjøre gjennom
arrayet T gitt i parameteren og satte hver node sin verdi til hvilket loop løkken var i f.eks. dersom i som variablet
til for løkken var 2 var noden verdi som var generert a[i]. I tillegg testet jeg relasjonenen for halen og hodet sine
neste og forrige noder og deres verdier med test lister.

* Oppgave 2a:
For toString metoden startet jeg med en if settning etter å ha instansiert en string builder som spør om hode var lik
null dette var for å vite om den skulle legge til hode.verdi som ville ha returnet en feilmelding dersom hode var null.
Deretter skjører jeg igjennom listen med en while-løkke og currentNode som startet fra hode til halen og til slutt
appended "]" i stringbuilderen, og deretter returnere string builder variabelet sitt toString metode. For omvendtString
startet jeg istedet fra halen til hodet med en for løkke istedet og antall attributten og deretter testet metoden.

* Oppgave 2b:
For 2b startet jeg med å kontrollere den oppgitt verdien med requireNonNull og deretter la til en ny node på slutten av
listen med som refererte frem tilbake mellom den forrige med neste og forrige attributtene og sette hale til den nye
noden og øke antall og endringer. 

* Oppgave 3:
Jeg implementerte finnNode metoden med en for løkke og variablet currentNode fra hode og brukte
currentNode = currentNode.neste inn til jeg rukket indeksen. I tillegg starter metoden fra hale eller hode vis det er
større enn antallet delt på 2. Hent bruker da finnNode for hente verdien til indeksen oppgitt mens oppdater bruker
finnNode til oppdattere verdien til den hentede noden og øker da endringer med 1. Subliste metoden instansierer et 
nytt DobbelLenketListe objekt som da fra det gitte området for hver verdi bruker legg inn metoden til listen.

* Oppgave 4:
For indekstil brukte jeg den generelle currentNode metode brukt oppe igjen i en while løkke som da sjekker om
currentNode som startet fra hode sin verdi er lik den gitt og dersom dette blir true returnere oppgave en teller som 
ble instansiert med verdi lik 0 utafor while løkken som for hver loop økes med en. dersom while løkken kjører igjennom
hele listen uten å finne verdien returneres det etter while løkken -1. of inneholder returnerte jeg bare
indekstil(verdi) != -1 slik at dersom indekstil fant verdien returneres true og false vis ikke.

* Oppgave 5


* Oppgave 6


* Oppgave 7


* Oppgave 8