package org.knowm.xchange.hitbtc.v2;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.account.AccountInfo;
import org.knowm.xchange.hitbtc.v2.dto.HitbtcBalance;

public class HitbtcAdaptersTest {

  // @Rule
  // public final ExpectedException exception = ExpectedException.none();

  @Test
  public void testAdaptWallet_getBalance() {
    try {
      List<HitbtcBalance> main = new ArrayList<>();
      main.add(new HitbtcBalance("BTC", new BigDecimal("0.1234"), new BigDecimal("32.23")));
      List<HitbtcBalance> trading = new ArrayList<>();
      trading.add(new HitbtcBalance("BTC", new BigDecimal("0.111"), BigDecimal.ZERO));

      AccountInfo accountInfo =
          new AccountInfo(
              HitbtcAdapters.adaptWallet("Main", main),
              HitbtcAdapters.adaptWallet("Trading", trading));

      assertThat(accountInfo).isNotNull();

      // Getting balance with two wallets not supported
      accountInfo.getWallet().getBalance(Currency.BTC);
    } catch (Exception e) {
      assertThat(e instanceof UnsupportedOperationException);
      assertThat(e.getMessage().equals("2 wallets in account"));
    }
  }

  @Test
  public void testAdaptSymbol() {
    String[] symbols = {
      "BCNBTC",
      "BTCUSD",
      "DASHBTC",
      "DOGEBTC",
      "DOGEUSD",
      "DSHBTC",
      "EMCBTC",
      "ETHBTC",
      "FCNBTC",
      "LSKBTC",
      "LTCBTC",
      "LTCUSD",
      "NXTBTC",
      "SBDBTC",
      "SCBTC",
      "STEEMBTC",
      "XDNBTC",
      "XEMBTC",
      "XMRBTC",
      "ARDRBTC",
      "ZECBTC",
      "WAVESBTC",
      "MAIDBTC",
      "AMPBTC",
      "BUSBTC",
      "DGDBTC",
      "ICNBTC",
      "SNGLSBTC",
      "1STBTC",
      "TRSTBTC",
      "TIMEBTC",
      "GNOBTC",
      "REPBTC",
      "XMRUSD",
      "DASHUSD",
      "ETHUSD",
      "NXTUSD",
      "ZRCBTC",
      "BOSBTC",
      "DCTBTC",
      "ANTBTC",
      "AEONBTC",
      "GUPBTC",
      "PLUBTC",
      "LUNBTC",
      "TAASBTC",
      "NXCBTC",
      "EDGBTC",
      "RLCBTC",
      "SWTBTC",
      "TKNBTC",
      "WINGSBTC",
      "XAURBTC",
      "AEBTC",
      "PTOYBTC",
      "ZECUSD",
      "XEMUSD",
      "BCNUSD",
      "XDNUSD",
      "MAIDUSD",
      "ETCBTC",
      "ETCUSD",
      "CFIBTC",
      "PLBTBTC",
      "BNTBTC",
      "FYNETH",
      "SNMBTC",
      "SNMETH",
      "SNTETH",
      "CVCUSD",
      "PAYETH",
      "OAXETH",
      "OMGETH",
      "BQXETH",
      "XTZBTC",
      "DICEBTC",
      "CFIETH",
      "PTOYETH",
      "1STETH",
      "XAURETH",
      "TAASETH",
      "TIMEETH",
      "DICEETH",
      "SWTETH",
      "XMRETH",
      "ETCETH",
      "DASHETH",
      "ZECETH",
      "PLUETH",
      "GNOETH",
      "XRPBTC",
      "NETETH",
      "STRATUSD",
      "STRATBTC",
      "SNCETH",
      "ADXETH",
      "BETETH",
      "EOSETH",
      "DENTETH",
      "SANETH",
      "EOSBTC",
      "EOSUSD",
      "MNEBTC",
      "MSPETH",
      "DDFETH",
      "XTZETH",
      "XTZUSD",
      "UETETH",
      "MYBETH",
      "SURETH",
      "IXTETH",
      "PLRETH",
      "TIXETH",
      "NDCETH",
      "PROETH",
      "AVTETH",
      "COSSETH",
      "EVXUSD",
      "DLTBTC",
      "BNTETH",
      "BNTUSD",
      "QAUBTC",
      "QAUETH",
      "MANAUSD",
      "DNTBTC",
      "FYPBTC",
      "OPTBTC",
      "TNTETH",
      "IFTBTC",
      "STXBTC",
      "STXETH",
      "STXUSD",
      "TNTUSD",
      "TNTBTC",
      "CATBTC",
      "CATETH",
      "CATUSD",
      "BCHBTC",
      "BCHETH",
      "BCHUSD",
      "ENGETH",
      "XUCUSD",
      "SNCBTC",
      "SNCUSD",
      "OAXUSD",
      "OAXBTC",
      "BASETH",
      "ZRXBTC",
      "ZRXETH",
      "ZRXUSD",
      "RVTBTC",
      "ICOSBTC",
      "ICOSETH",
      "ICOSUSD",
      "PPCBTC",
      "PPCUSD",
      "QTUMETH",
      "VERIBTC",
      "VERIETH",
      "VERIUSD",
      "IGNISETH",
      "PRGBTC",
      "PRGETH",
      "PRGUSD",
      "BMCBTC",
      "BMCETH",
      "BMCUSD",
      "CNDBTC",
      "CNDETH",
      "CNDUSD",
      "SKINBTC",
      "EMGOBTC",
      "EMGOUSD",
      "CDTETH",
      "CDTUSD",
      "FUNBTC",
      "FUNETH",
      "FUNUSD",
      "HVNBTC",
      "HVNETH",
      "FUELBTC",
      "FUELETH",
      "FUELUSD",
      "POEBTC",
      "POEETH",
      "MCAPBTC",
      "AIRBTC",
      "AIRETH",
      "AIRUSD",
      "AMBUSD",
      "AMBETH",
      "AMBBTC",
      "NTOBTC",
      "ICOBTC",
      "PINGBTC",
      "GAMEBTC",
      "TKRETH",
      "HPCBTC",
      "PPTETH",
      "MTHBTC",
      "MTHETH",
      "WMGOBTC",
      "WMGOUSD",
      "LRCBTC",
      "LRCETH",
      "ICXBTC",
      "ICXETH",
      "NEOBTC",
      "NEOETH",
      "NEOUSD",
      "CSNOBTC",
      "ORMEBTC",
      "ICXUSD",
      "PIXBTC",
      "PIXETH",
      "INDETH",
      "KICKBTC",
      "YOYOWBTC",
      "MIPSBTC",
      "CDTBTC",
      "XVGBTC",
      "XVGETH",
      "XVGUSD",
      "DGBBTC",
      "DGBETH",
      "DGBUSD",
      "DCNBTC",
      "DCNETH",
      "DCNUSD",
      "CCTETH",
      "EBETETH",
      "VIBEBTC",
      "VOISEBTC",
      "ENJBTC",
      "ENJETH",
      "ENJUSD",
      "ZSCBTC",
      "ZSCETH",
      "ZSCUSD",
      "ETBSBTC",
      "TRXBTC",
      "TRXETH",
      "TRXUSD",
      "VENBTC",
      "VENETH",
      "VENUSD",
      "ARTBTC",
      "EVXBTC",
      "EVXETH",
      "QVTETH",
      "EBTCOLDBTC",
      "EBTCOLDETH",
      "EBTCOLDUSD",
      "BKBBTC",
      "EXNBTC",
      "TGTBTC",
      "ATSETH",
      "BMTBTC",
      "BMTETH",
      "SUBBTC",
      "SUBETH",
      "SUBUSD",
      "WTCBTC",
      "CNXBTC",
      "ATBBTC",
      "ATBETH",
      "ATBUSD",
      "ODNBTC",
      "BTMBTC",
      "BTMETH",
      "BTMUSD",
      "B2XBTC",
      "B2XETH",
      "B2XUSD",
      "ATMBTC",
      "ATMETH",
      "ATMUSD",
      "LIFEBTC",
      "VIBBTC",
      "VIBETH",
      "VIBUSD",
      "DRTETH",
      "STUUSD",
      "OMGBTC",
      "PAYBTC",
      "COSSBTC",
      "PPTBTC",
      "SNTBTC",
      "BTGBTC",
      "BTGETH",
      "BTGUSD",
      "SMARTBTC",
      "SMARTETH",
      "SMARTUSD",
      "XUCETH",
      "XUCBTC",
      "LAETH",
      "CLDBTC",
      "CLDETH",
      "CLDUSD",
      "EDOBTC",
      "EDOETH",
      "EDOUSD",
      "HGTETH",
      "POLLBTC",
      "IXTBTC",
      "ATSBTC",
      "SCLBTC",
      "ATLBTC",
      "EBTCBTC",
      "EBTCETH",
      "EBTCUSD",
      "ETPBTC",
      "ETPETH",
      "ETPUSD",
      "OTXBTC",
      "CDXETH",
      "DRPUBTC",
      "NEBLBTC",
      "NEBLETH",
      "HACBTC",
      "CTXBTC",
      "CTXETH",
      "ELEBTC",
      "ARNBTC",
      "ARNETH",
      "STUBTC",
      "STUETH",
      "GVTETH",
      "INDIBTC",
      "BTXBTC",
      "LTCETH",
      "BCNETH",
      "MAIDETH",
      "NXTETH",
      "STRATETH",
      "XDNETH",
      "XEMETH",
      "PLRBTC",
      "SURBTC",
      "BQXBTC",
      "DOGEETH",
      "ITSBTC",
      "AMMBTC",
      "AMMETH",
      "AMMUSD",
      "DBIXBTC",
      "PREBTC",
      "KBRBTC",
      "TBTBTC",
      "EROBTC",
      "SMSBTC",
      "SMSETH",
      "SMSUSD",
      "ZAPBTC",
      "DOVBTC",
      "DOVETH",
      "DRPUETH",
      "OTNBTC",
      "XRPETH",
      "XRPUSD",
      "HSRBTC",
      "LENDBTC",
      "LENDETH",
      "SPFBTC",
      "SPFETH",
      "SBTCBTC",
      "SBTCETH",
      "WRCBTC",
      "WRCETH",
      "WRCUSD",
      "LOCBTC",
      "LOCETH",
      "LOCUSD",
      "SWFTCBTC",
      "SWFTCETH",
      "SWFTCUSD",
      "STARETH",
      "SBTCUSD",
      "STORMBTC",
      "DIMETH",
      "DIMUSD",
      "DIMBTC",
      "NGCBTC",
      "NGCETH",
      "NGCUSD",
      "EMCETH",
      "EMCUSD",
      "MCOBTC",
      "MCOETH",
      "MCOUSD",
      "MANAETH",
      "MANABTC",
      "ECHBTC",
      "CPAYETH",
      "DATABTC",
      "DATAETH",
      "DATAUSD",
      "UTTBTC",
      "UTTETH",
      "UTTUSD",
      "KMDBTC",
      "KMDETH",
      "KMDUSD",
      "QTUMUSD",
      "QTUMBTC",
      "SNTUSD",
      "OMGUSD",
      "EKOBTC",
      "EKOETH",
      "ADXBTC",
      "ADXUSD",
      "LSKETH",
      "LSKUSD",
      "PLRUSD",
      "SURUSD",
      "BQXUSD",
      "DRTUSD",
      "REPETH",
      "REPUSD",
      "TIOBTC",
      "TIOETH",
      "TIOUSD",
      "WAXBTC",
      "WAXETH",
      "WAXUSD",
      "EETBTC",
      "EETETH",
      "EETUSD",
      "C20BTC",
      "C20ETH",
      "IDHBTC",
      "IDHETH",
      "IPLBTC",
      "COVBTC",
      "COVETH",
      "SENTBTC",
      "SENTETH",
      "SENTUSD",
      "SMTBTC",
      "SMTETH",
      "SMTUSD",
      "CASBTC",
      "CASETH",
      "CASUSD",
      "CHATBTC",
      "CHATETH",
      "CHATUSD",
      "GRMDBTC",
      "AVHBTC",
      "TRACETH",
      "JNTETH",
      "PCLBTC",
      "PCLETH",
      "CLOUTBTC",
      "UTKBTC",
      "UTKETH",
      "UTKUSD",
      "GNXETH",
      "CHSBBTC",
      "CHSBETH",
      "AVHETH",
      "DAYBTC",
      "DAYETH",
      "DAYUSD",
      "NEUBTC",
      "NEUETH",
      "NEUUSD",
      "AVHUSD",
      "CLOUTETH",
      "CLOUTUSD",
      "TAUBTC",
      "MEKBTC",
      "FLPBTC",
      "FLPETH",
      "FLPUSD",
      "RBTC",
      "RETH",
      "EKOUSD",
      "BCPTETH",
      "BCPTUSD",
      "PKTBTC",
      "PKTETH",
      "WLKBTC",
      "WLKETH",
      "WLKUSD",
      "CPGBTC",
      "CPGETH",
      "BPTNBTC",
      "BPTNETH",
      "BPTNUSD",
      "BETRBTC",
      "BETRETH",
      "ARCTBTC",
      "ARCTUSD",
      "DBETBTC",
      "DBETETH",
      "DBETUSD",
      "RNTBETH",
      "HANDETH",
      "HANDUSD",
      "ACOETH",
      "CTEBTC",
      "CTEETH",
      "CTEUSD",
      "CPYBTC",
      "CPYETH",
      "CHPETH",
      "BCPTBTC",
      "ACTBTC",
      "ACTETH",
      "ACTUSD",
      "HIREETH",
      "ADABTC",
      "ADAETH",
      "ADAUSD",
      "SIGBTC",
      "RPMBTC",
      "RPMETH",
      "MTXBTC",
      "MTXETH",
      "MTXUSD",
      "BGGBTC",
      "BGGETH",
      "BGGUSD",
      "SETHETH",
      "WIZBTC",
      "WIZETH",
      "WIZUSD",
      "DADIBTC",
      "DADIETH",
      "BDGETH",
      "DATXBTC",
      "DATXETH",
      "TRUEBTC",
      "DRGBTC",
      "DRGETH",
      "BANCABTC",
      "BANCAETH",
      "ZAPETH",
      "ZAPUSD",
      "AUTOBTC",
      "NOAHBTC",
      "SOCBTC",
      "WILDBTC",
      "INSURBTC",
      "INSURETH",
      "OCNBTC",
      "OCNETH",
      "STQBTC",
      "STQETH",
      "XLMBTC",
      "XLMETH",
      "XLMUSD",
      "IOTABTC",
      "IOTAETH",
      "IOTAUSD",
      "DRTBTC",
      "MLDBTC",
      "MLDETH",
      "MLDUSD",
      "BETRUSD",
      "CGCETH",
      "CRPTBTC",
      "CRPTUSD",
      "MESHBTC",
      "MESHETH",
      "MESHUSD",
      "HLWETH",
      "IHTBTC",
      "IHTETH",
      "IHTUSD",
      "SCCBTC",
      "YCCBTC",
      "DANBTC",
      "TELBTC",
      "TELETH",
      "BUBOBTC",
      "BUBOETH",
      "BUBOUSD",
      "VITBTC",
      "VITETH",
      "VITUSD",
      "NCTBTC",
      "NCTETH",
      "NCTUSD",
      "AXPBTC",
      "AXPETH",
      "BMHBTC",
      "BANCAUSD",
      "NOAHETH",
      "NOAHUSD",
      "HQXBTC",
      "LDCBTC",
      "XMOBTC",
      "XMOUSD",
      "XMOETH",
      "BERRYBTC",
      "BERRYETH",
      "BERRYUSD",
      "BSTNBTC",
      "BSTNETH",
      "BSTNUSD",
      "GBXBTC",
      "GBXETH",
      "GBXUSD",
      "SHIPBTC",
      "SHIPETH",
      "NANOBTC",
      "NANOETH",
      "NANOUSD",
      "LNCBTC",
      "UNCBTC",
      "UNCETH",
      "RPXBTC",
      "RPXETH",
      "RPXUSD",
      "KINETH",
      "ARDRUSD",
      "DAXTBTC",
      "DAXTETH",
      "FOTAETH",
      "FOTABTC",
      "SETHBTC",
      "CVTBTC",
      "CVTETH",
      "CVTUSD",
      "STQUSD",
      "GNTBTC",
      "GNTETH",
      "GNTUSD",
      "ADHBTC",
      "ADHETH",
      "BBCBTC",
      "BBCETH",
      "GETBTC",
      "MITHBTC",
      "MITHETH",
      "MITHUSD",
      "SUNCETH",
      "DADIUSD",
      "TKYBTC",
      "ACATBTC",
      "ACATETH",
      "ACATUSD",
      "BTXUSD",
      "TCNBTC",
      "VIOETH",
      "WIKIBTC",
      "WIKIETH",
      "WIKIUSD",
      "ONTBTC",
      "ONTETH",
      "ONTUSD",
      "CVCOINBTC",
      "CVCOINETH",
      "CVCOINUSD",
      "FTXBTC",
      "FTXETH",
      "FRECBTC",
      "NAVIBTC",
      "FRECETH",
      "FRECUSD",
      "VMEETH",
      "NAVIETH",
      "BTCPBTC",
      "LNDETH",
      "CSMBTC",
      "NANJBTC",
      "NTKBTC",
      "NTKETH",
      "NTKUSD",
      "AUCBTC",
      "AUCETH",
      "CMCTBTC",
      "CMCTETH",
      "CMCTUSD",
      "MANBTC",
      "MANETH",
      "MANUSD",
      "HIREBTC",
      "TKABTC",
      "TKAETH",
      "TKAUSD",
      "PNTBTC",
      "PNTETH",
      "FXTBTC",
      "NEXOBTC",
      "CHXBTC",
      "CHXETH",
      "CHXUSD",
      "PATBTC",
      "PATETH",
      "XMCBTC",
      "EJOYBTC",
      "EJOYETH",
      "EJOYUSD",
      "FXTETH",
      "HEROBTC",
      "HEROETH",
      "XMCETH",
      "XMCUSD",
      "STAKBTC",
      "STAKETH",
      "FDZBTC",
      "FDZETH",
      "FDZUSD",
      "SPDBTC",
      "SPDETH",
      "LUCBTC",
      "MITXBTC",
      "TIVBTC",
      "B2GBTC",
      "B2GUSD",
      "ZPTBTC",
      "ZPTETH",
      "HBZBTC",
      "FACEBTC",
      "FACEETH",
      "HBZETH",
      "HBZUSD",
      "ZPTUSD",
      "MORPHBTC",
      "MORPHETH",
      "MORPHUSD",
      "EBKCBTC",
      "CPTBTC",
      "PATUSD",
      "HTMLBTC",
      "HTMLETH",
      "MITXETH",
      "JOTBTC",
      "JBCBTC",
      "JBCETH",
      "BTSBTC",
      "BNKBTC",
      "KBCBTC",
      "KBCETH",
      "BNKETH",
      "BNKUSD",
      "TIVETH",
      "TIVUSD",
      "LUCETH",
      "LUCUSD",
      "CSMETH",
      "CSMUSD",
      "INKBTC",
      "SPCBTC",
      "IOSTBTC",
      "INKETH",
      "INKUSD",
      "SPCETH",
      "SPCUSD",
      "CBCBTC",
      "IOSTUSD",
      "COINBTC",
      "ZILBTC",
      "COINUSD",
      "COINETH",
      "PMNTBTC",
      "ABYSSBTC",
      "ABYSSETH",
      "ZILUSD",
      "BCIBTC",
      "CBCETH",
      "CBCUSD",
      "PITCHBTC",
      "PITCHETH",
      "HTMLUSD",
      "TDSBTC",
      "TDSETH",
      "TDSUSD",
      "SBDETH",
      "SBDUSD",
      "DPNBTC",
      "UUUBTC",
      "UUUETH",
      "XBPBTC",
      "KRMUSD",
      "CLNBTC",
      "IVYBTC",
      "IVYETH",
      "TTUBTC",
      "TTUETH",
      "TTUUSD",
      "CLNETH",
      "DORBTC",
      "DORETH",
      "DORUSD",
      "ELECBTC",
      "ELECETH",
      "ELECUSD",
      "QNTUBTC",
      "QNTUETH",
      "QNTUUSD",
      "IPLETH",
      "IPLUSD",
      "CENNZBTC",
      "BTCPETH",
      "BTCPUSD",
      "CENNZETH",
      "SWMBTC",
      "MXMBTC",
      "MXMETH",
      "SPFUSD",
      "LCCBTC",
      "HGTBTC",
      "BTCDAI",
      "ETHDAI",
      "MKRDAI",
      "EOSDAI",
      "USDDAI",
      "ETHTUSD",
      "BTCTUSD",
      "LTCTUSD",
      "XMRTUSD",
      "ZRXTUSD",
      "NEOTUSD",
      "BCHTUSD",
      "USDTUSD",
      "MKRBTC",
      "MKRETH",
      "MKRUSD",
      "TUSDDAI",
      "NEODAI",
      "LTCDAI",
      "XMRDAI",
      "BCHDAI",
      "XRPDAI",
      "NEXOETH",
      "NEXOUSD",
      "DWSBTC",
      "DWSETH",
      "DWSUSD",
      "APPCBTC",
      "APPCETH",
      "APPCUSD",
      "BITETH",
      "DASHEURS",
      "ZECEURS",
      "BTCEURS",
      "EOSEURS",
      "ETHEURS",
      "LTCEURS",
      "BCHEURS",
      "NEOEURS",
      "XMREURS",
      "XRPEURS",
      "REXBTC",
      "REXETH",
      "REXUSD",
      "BCDBTC",
      "ELFBTC",
      "ELFUSD",
      "BCDUSD",
      "HQXETH",
      "HQXUSD",
      "EBKCETH",
      "EBKCUSD",
      "EDGETH",
      "EDGUSD",
      "COSMBTC",
      "COSMETH",
      "DCNTBTC",
      "DCNTETH",
      "DCNTUSD",
      "EURSUSD",
      "EURSTUSD",
      "EURSDAI",
      "MNXUSD",
      "ROXETH",
      "ZPRETH",
      "MNXBTC",
      "MNXETH",
      "KINDBTC",
      "KINDETH",
      "ENGTBTC",
      "ENGTETH",
      "PMABTC",
      "PMAETH",
      "TVBTC",
      "TVETH",
      "TVUSD"
    };
    String[] bases = {
      "BCN", "BTC", "DASH", "DOGE", "DOGE", "DSH", "EMC", "ETH", "FCN", "LSK", "LTC", "LTC", "NXT",
      "SBD", "SC", "STEEM", "XDN", "XEM", "XMR", "ARDR", "ZEC", "WAVES", "MAID", "AMP", "BUS",
      "DGD", "ICN", "SNGLS", "1ST", "TRST", "TIME", "GNO", "REP", "XMR", "DASH", "ETH", "NXT",
      "ZRC", "BOS", "DCT", "ANT", "AEON", "GUP", "PLU", "LUN", "TAAS", "NXC", "EDG", "RLC", "SWT",
      "TKN", "WINGS", "XAUR", "AE", "PTOY", "ZEC", "XEM", "BCN", "XDN", "MAID", "ETC", "ETC", "CFI",
      "PLBT", "BNT", "FYN", "SNM", "SNM", "SNT", "CVC", "PAY", "OAX", "OMG", "BQX", "XTZ", "DICE",
      "CFI", "PTOY", "1ST", "XAUR", "TAAS", "TIME", "DICE", "SWT", "XMR", "ETC", "DASH", "ZEC",
      "PLU", "GNO", "XRP", "NET", "STRAT", "STRAT", "SNC", "ADX", "BET", "EOS", "DENT", "SAN",
      "EOS", "EOS", "MNE", "MSP", "DDF", "XTZ", "XTZ", "UET", "MYB", "SUR", "IXT", "PLR", "TIX",
      "NDC", "PRO", "AVT", "COSS", "EVX", "DLT", "BNT", "BNT", "QAU", "QAU", "MANA", "DNT", "FYP",
      "OPT", "TNT", "IFT", "STX", "STX", "STX", "TNT", "TNT", "CAT", "CAT", "CAT", "BCH", "BCH",
      "BCH", "ENG", "XUC", "SNC", "SNC", "OAX", "OAX", "BAS", "ZRX", "ZRX", "ZRX", "RVT", "ICOS",
      "ICOS", "ICOS", "PPC", "PPC", "QTUM", "VERI", "VERI", "VERI", "IGNIS", "PRG", "PRG", "PRG",
      "BMC", "BMC", "BMC", "CND", "CND", "CND", "SKIN", "EMGO", "EMGO", "CDT", "CDT", "FUN", "FUN",
      "FUN", "HVN", "HVN", "FUEL", "FUEL", "FUEL", "POE", "POE", "MCAP", "AIR", "AIR", "AIR", "AMB",
      "AMB", "AMB", "NTO", "ICO", "PING", "GAME", "TKR", "HPC", "PPT", "MTH", "MTH", "WMGO", "WMGO",
      "LRC", "LRC", "ICX", "ICX", "NEO", "NEO", "NEO", "CSNO", "ORME", "ICX", "PIX", "PIX", "IND",
      "KICK", "YOYOW", "MIPS", "CDT", "XVG", "XVG", "XVG", "DGB", "DGB", "DGB", "DCN", "DCN", "DCN",
      "CCT", "EBET", "VIBE", "VOISE", "ENJ", "ENJ", "ENJ", "ZSC", "ZSC", "ZSC", "ETBS", "TRX",
      "TRX", "TRX", "VEN", "VEN", "VEN", "ART", "EVX", "EVX", "QVT", "EBTCOLD", "EBTCOLD",
      "EBTCOLD", "BKB", "EXN", "TGT", "ATS", "BMT", "BMT", "SUB", "SUB", "SUB", "WTC", "CNX", "ATB",
      "ATB", "ATB", "ODN", "BTM", "BTM", "BTM", "B2X", "B2X", "B2X", "ATM", "ATM", "ATM", "LIFE",
      "VIB", "VIB", "VIB", "DRT", "STU", "OMG", "PAY", "COSS", "PPT", "SNT", "BTG", "BTG", "BTG",
      "SMART", "SMART", "SMART", "XUC", "XUC", "LA", "CLD", "CLD", "CLD", "EDO", "EDO", "EDO",
      "HGT", "POLL", "IXT", "ATS", "SCL", "ATL", "EBTC", "EBTC", "EBTC", "ETP", "ETP", "ETP", "OTX",
      "CDX", "DRPU", "NEBL", "NEBL", "HAC", "CTX", "CTX", "ELE", "ARN", "ARN", "STU", "STU", "GVT",
      "INDI", "BTX", "LTC", "BCN", "MAID", "NXT", "STRAT", "XDN", "XEM", "PLR", "SUR", "BQX",
      "DOGE", "ITS", "AMM", "AMM", "AMM", "DBIX", "PRE", "KBR", "TBT", "ERO", "SMS", "SMS", "SMS",
      "ZAP", "DOV", "DOV", "DRPU", "OTN", "XRP", "XRP", "HSR", "LEND", "LEND", "SPF", "SPF", "SBTC",
      "SBTC", "WRC", "WRC", "WRC", "LOC", "LOC", "LOC", "SWFTC", "SWFTC", "SWFTC", "STAR", "SBTC",
      "STORM", "DIM", "DIM", "DIM", "NGC", "NGC", "NGC", "EMC", "EMC", "MCO", "MCO", "MCO", "MANA",
      "MANA", "ECH", "CPAY", "DATA", "DATA", "DATA", "UTT", "UTT", "UTT", "KMD", "KMD", "KMD",
      "QTUM", "QTUM", "SNT", "OMG", "EKO", "EKO", "ADX", "ADX", "LSK", "LSK", "PLR", "SUR", "BQX",
      "DRT", "REP", "REP", "TIO", "TIO", "TIO", "WAX", "WAX", "WAX", "EET", "EET", "EET", "C20",
      "C20", "IDH", "IDH", "IPL", "COV", "COV", "SENT", "SENT", "SENT", "SMT", "SMT", "SMT", "CAS",
      "CAS", "CAS", "CHAT", "CHAT", "CHAT", "GRMD", "AVH", "TRAC", "JNT", "PCL", "PCL", "CLOUT",
      "UTK", "UTK", "UTK", "GNX", "CHSB", "CHSB", "AVH", "DAY", "DAY", "DAY", "NEU", "NEU", "NEU",
      "AVH", "CLOUT", "CLOUT", "TAU", "MEK", "FLP", "FLP", "FLP", "R", "R", "EKO", "BCPT", "BCPT",
      "PKT", "PKT", "WLK", "WLK", "WLK", "CPG", "CPG", "BPTN", "BPTN", "BPTN", "BETR", "BETR",
      "ARCT", "ARCT", "DBET", "DBET", "DBET", "RNTB", "HAND", "HAND", "ACO", "CTE", "CTE", "CTE",
      "CPY", "CPY", "CHP", "BCPT", "ACT", "ACT", "ACT", "HIRE", "ADA", "ADA", "ADA", "SIG", "RPM",
      "RPM", "MTX", "MTX", "MTX", "BGG", "BGG", "BGG", "SETH", "WIZ", "WIZ", "WIZ", "DADI", "DADI",
      "BDG", "DATX", "DATX", "TRUE", "DRG", "DRG", "BANCA", "BANCA", "ZAP", "ZAP", "AUTO", "NOAH",
      "SOC", "WILD", "INSUR", "INSUR", "OCN", "OCN", "STQ", "STQ", "XLM", "XLM", "XLM", "IOTA",
      "IOTA", "IOTA", "DRT", "MLD", "MLD", "MLD", "BETR", "CGC", "CRPT", "CRPT", "MESH", "MESH",
      "MESH", "HLW", "IHT", "IHT", "IHT", "SCC", "YCC", "DAN", "TEL", "TEL", "BUBO", "BUBO", "BUBO",
      "VIT", "VIT", "VIT", "NCT", "NCT", "NCT", "AXP", "AXP", "BMH", "BANCA", "NOAH", "NOAH", "HQX",
      "LDC", "XMO", "XMO", "XMO", "BERRY", "BERRY", "BERRY", "BSTN", "BSTN", "BSTN", "GBX", "GBX",
      "GBX", "SHIP", "SHIP", "NANO", "NANO", "NANO", "LNC", "UNC", "UNC", "RPX", "RPX", "RPX",
      "KIN", "ARDR", "DAXT", "DAXT", "FOTA", "FOTA", "SETH", "CVT", "CVT", "CVT", "STQ", "GNT",
      "GNT", "GNT", "ADH", "ADH", "BBC", "BBC", "GET", "MITH", "MITH", "MITH", "SUNC", "DADI",
      "TKY", "ACAT", "ACAT", "ACAT", "BTX", "TCN", "VIO", "WIKI", "WIKI", "WIKI", "ONT", "ONT",
      "ONT", "CVCOIN", "CVCOIN", "CVCOIN", "FTX", "FTX", "FREC", "NAVI", "FREC", "FREC", "VME",
      "NAVI", "BTCP", "LND", "CSM", "NANJ", "NTK", "NTK", "NTK", "AUC", "AUC", "CMCT", "CMCT",
      "CMCT", "MAN", "MAN", "MAN", "HIRE", "TKA", "TKA", "TKA", "PNT", "PNT", "FXT", "NEXO", "CHX",
      "CHX", "CHX", "PAT", "PAT", "XMC", "EJOY", "EJOY", "EJOY", "FXT", "HERO", "HERO", "XMC",
      "XMC", "STAK", "STAK", "FDZ", "FDZ", "FDZ", "SPD", "SPD", "LUC", "MITX", "TIV", "B2G", "B2G",
      "ZPT", "ZPT", "HBZ", "FACE", "FACE", "HBZ", "HBZ", "ZPT", "MORPH", "MORPH", "MORPH", "EBKC",
      "CPT", "PAT", "HTML", "HTML", "MITX", "JOT", "JBC", "JBC", "BTS", "BNK", "KBC", "KBC", "BNK",
      "BNK", "TIV", "TIV", "LUC", "LUC", "CSM", "CSM", "INK", "SPC", "IOST", "INK", "INK", "SPC",
      "SPC", "CBC", "IOST", "COIN", "ZIL", "COIN", "COIN", "PMNT", "ABYSS", "ABYSS", "ZIL", "BCI",
      "CBC", "CBC", "PITCH", "PITCH", "HTML", "TDS", "TDS", "TDS", "SBD", "SBD", "DPN", "UUU",
      "UUU", "XBP", "KRM", "CLN", "IVY", "IVY", "TTU", "TTU", "TTU", "CLN", "DOR", "DOR", "DOR",
      "ELEC", "ELEC", "ELEC", "QNTU", "QNTU", "QNTU", "IPL", "IPL", "CENNZ", "BTCP", "BTCP",
      "CENNZ", "SWM", "MXM", "MXM", "SPF", "LCC", "HGT", "BTC", "ETH", "MKR", "EOS", "USD", "ETH",
      "BTC", "LTC", "XMR", "ZRX", "NEO", "BCH", "USD", "MKR", "MKR", "MKR", "TUSD", "NEO", "LTC",
      "XMR", "BCH", "XRP", "NEXO", "NEXO", "DWS", "DWS", "DWS", "APPC", "APPC", "APPC", "BIT",
      "DASH", "ZEC", "BTC", "EOS", "ETH", "LTC", "BCH", "NEO", "XMR", "XRP", "REX", "REX", "REX",
      "BCD", "ELF", "ELF", "BCD", "HQX", "HQX", "EBKC", "EBKC", "EDG", "EDG", "COSM", "COSM",
      "DCNT", "DCNT", "DCNT", "EURS", "EURS", "EURS", "MNX", "ROX", "ZPR", "MNX", "MNX", "KIND",
      "KIND", "ENGT", "ENGT", "PMA", "PMA", "TV", "TV", "TV"
    };
    String[] counters = {
      "BTC", "USD", "BTC", "BTC", "USD", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "USD", "BTC",
      "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC",
      "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "USD", "USD", "USD", "USD", "BTC", "BTC",
      "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC",
      "BTC", "BTC", "BTC", "USD", "USD", "USD", "USD", "USD", "BTC", "USD", "BTC", "BTC", "BTC",
      "ETH", "BTC", "ETH", "ETH", "USD", "ETH", "ETH", "ETH", "ETH", "BTC", "BTC", "ETH", "ETH",
      "ETH", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH", "BTC",
      "ETH", "USD", "BTC", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH", "BTC", "USD", "BTC", "ETH",
      "ETH", "ETH", "USD", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH",
      "USD", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "BTC", "BTC", "BTC", "ETH", "BTC", "BTC",
      "ETH", "USD", "USD", "BTC", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "ETH", "USD", "BTC",
      "USD", "USD", "BTC", "ETH", "BTC", "ETH", "USD", "BTC", "BTC", "ETH", "USD", "BTC", "USD",
      "ETH", "BTC", "ETH", "USD", "ETH", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "BTC", "ETH",
      "USD", "BTC", "BTC", "USD", "ETH", "USD", "BTC", "ETH", "USD", "BTC", "ETH", "BTC", "ETH",
      "USD", "BTC", "ETH", "BTC", "BTC", "ETH", "USD", "USD", "ETH", "BTC", "BTC", "BTC", "BTC",
      "BTC", "ETH", "BTC", "ETH", "BTC", "ETH", "BTC", "USD", "BTC", "ETH", "BTC", "ETH", "BTC",
      "ETH", "USD", "BTC", "BTC", "USD", "BTC", "ETH", "ETH", "BTC", "BTC", "BTC", "BTC", "BTC",
      "ETH", "USD", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "ETH", "ETH", "BTC", "BTC", "BTC",
      "ETH", "USD", "BTC", "ETH", "USD", "BTC", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "BTC",
      "BTC", "ETH", "ETH", "BTC", "ETH", "USD", "BTC", "BTC", "BTC", "ETH", "BTC", "ETH", "BTC",
      "ETH", "USD", "BTC", "BTC", "BTC", "ETH", "USD", "BTC", "BTC", "ETH", "USD", "BTC", "ETH",
      "USD", "BTC", "ETH", "USD", "BTC", "BTC", "ETH", "USD", "ETH", "USD", "BTC", "BTC", "BTC",
      "BTC", "BTC", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "ETH", "BTC", "ETH", "BTC", "ETH",
      "USD", "BTC", "ETH", "USD", "ETH", "BTC", "BTC", "BTC", "BTC", "BTC", "BTC", "ETH", "USD",
      "BTC", "ETH", "USD", "BTC", "ETH", "BTC", "BTC", "ETH", "BTC", "BTC", "ETH", "BTC", "BTC",
      "ETH", "BTC", "ETH", "ETH", "BTC", "BTC", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH", "ETH",
      "BTC", "BTC", "BTC", "ETH", "BTC", "BTC", "ETH", "USD", "BTC", "BTC", "BTC", "BTC", "BTC",
      "BTC", "ETH", "USD", "BTC", "BTC", "ETH", "ETH", "BTC", "ETH", "USD", "BTC", "BTC", "ETH",
      "BTC", "ETH", "BTC", "ETH", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "BTC", "ETH", "USD",
      "ETH", "USD", "BTC", "ETH", "USD", "BTC", "BTC", "ETH", "USD", "ETH", "USD", "BTC", "ETH",
      "USD", "ETH", "BTC", "BTC", "ETH", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "BTC", "ETH",
      "USD", "USD", "BTC", "USD", "USD", "BTC", "ETH", "BTC", "USD", "ETH", "USD", "USD", "USD",
      "USD", "USD", "ETH", "USD", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "BTC", "ETH", "USD",
      "BTC", "ETH", "BTC", "ETH", "BTC", "BTC", "ETH", "BTC", "ETH", "USD", "BTC", "ETH", "USD",
      "BTC", "ETH", "USD", "BTC", "ETH", "USD", "BTC", "BTC", "ETH", "ETH", "BTC", "ETH", "BTC",
      "BTC", "ETH", "USD", "ETH", "BTC", "ETH", "ETH", "BTC", "ETH", "USD", "BTC", "ETH", "USD",
      "USD", "ETH", "USD", "BTC", "BTC", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "ETH", "USD",
      "BTC", "ETH", "BTC", "ETH", "USD", "BTC", "ETH", "BTC", "ETH", "USD", "BTC", "ETH", "BTC",
      "USD", "BTC", "ETH", "USD", "ETH", "ETH", "USD", "ETH", "BTC", "ETH", "USD", "BTC", "ETH",
      "ETH", "BTC", "BTC", "ETH", "USD", "ETH", "BTC", "ETH", "USD", "BTC", "BTC", "ETH", "BTC",
      "ETH", "USD", "BTC", "ETH", "USD", "ETH", "BTC", "ETH", "USD", "BTC", "ETH", "ETH", "BTC",
      "ETH", "BTC", "BTC", "ETH", "BTC", "ETH", "ETH", "USD", "BTC", "BTC", "BTC", "BTC", "BTC",
      "ETH", "BTC", "ETH", "BTC", "ETH", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "BTC", "BTC",
      "ETH", "USD", "USD", "ETH", "BTC", "USD", "BTC", "ETH", "USD", "ETH", "BTC", "ETH", "USD",
      "BTC", "BTC", "BTC", "BTC", "ETH", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "BTC", "ETH",
      "USD", "BTC", "ETH", "BTC", "USD", "ETH", "USD", "BTC", "BTC", "BTC", "USD", "ETH", "BTC",
      "ETH", "USD", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "BTC", "ETH", "BTC", "ETH", "USD",
      "BTC", "BTC", "ETH", "BTC", "ETH", "USD", "ETH", "USD", "BTC", "ETH", "ETH", "BTC", "BTC",
      "BTC", "ETH", "USD", "USD", "BTC", "ETH", "USD", "BTC", "ETH", "BTC", "ETH", "BTC", "BTC",
      "ETH", "USD", "ETH", "USD", "BTC", "BTC", "ETH", "USD", "USD", "BTC", "ETH", "BTC", "ETH",
      "USD", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "BTC", "ETH", "BTC", "BTC", "ETH", "USD",
      "ETH", "ETH", "BTC", "ETH", "BTC", "BTC", "BTC", "ETH", "USD", "BTC", "ETH", "BTC", "ETH",
      "USD", "BTC", "ETH", "USD", "BTC", "BTC", "ETH", "USD", "BTC", "ETH", "BTC", "BTC", "BTC",
      "ETH", "USD", "BTC", "ETH", "BTC", "BTC", "ETH", "USD", "ETH", "BTC", "ETH", "ETH", "USD",
      "BTC", "ETH", "BTC", "ETH", "USD", "BTC", "ETH", "BTC", "BTC", "BTC", "BTC", "USD", "BTC",
      "ETH", "BTC", "BTC", "ETH", "ETH", "USD", "USD", "BTC", "ETH", "USD", "BTC", "BTC", "USD",
      "BTC", "ETH", "ETH", "BTC", "BTC", "ETH", "BTC", "BTC", "BTC", "ETH", "ETH", "USD", "ETH",
      "USD", "ETH", "USD", "ETH", "USD", "BTC", "BTC", "BTC", "ETH", "USD", "ETH", "USD", "BTC",
      "USD", "BTC", "BTC", "USD", "ETH", "BTC", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "BTC",
      "ETH", "USD", "BTC", "ETH", "USD", "ETH", "USD", "BTC", "BTC", "ETH", "BTC", "USD", "BTC",
      "BTC", "ETH", "BTC", "ETH", "USD", "ETH", "BTC", "ETH", "USD", "BTC", "ETH", "USD", "BTC",
      "ETH", "USD", "ETH", "USD", "BTC", "ETH", "USD", "ETH", "BTC", "BTC", "ETH", "USD", "BTC",
      "BTC", "DAI", "DAI", "DAI", "DAI", "DAI", "TUSD", "TUSD", "TUSD", "TUSD", "TUSD", "TUSD",
      "TUSD", "TUSD", "BTC", "ETH", "USD", "DAI", "DAI", "DAI", "DAI", "DAI", "DAI", "ETH", "USD",
      "BTC", "ETH", "USD", "BTC", "ETH", "USD", "ETH", "EURS", "EURS", "EURS", "EURS", "EURS",
      "EURS", "EURS", "EURS", "EURS", "EURS", "BTC", "ETH", "USD", "BTC", "BTC", "USD", "USD",
      "ETH", "USD", "ETH", "USD", "ETH", "USD", "BTC", "ETH", "BTC", "ETH", "USD", "USD", "TUSD",
      "DAI", "USD", "ETH", "ETH", "BTC", "ETH", "BTC", "ETH", "BTC", "ETH", "BTC", "ETH", "BTC",
      "ETH", "USD"
    };
    for (int i = 0; i < symbols.length; i++) {
      CurrencyPair parsedCurrencyPair = HitbtcAdapters.adaptSymbol(symbols[i]);
      String expectedBaseCurrency = bases[i];
      String expectedCounterCurrency = counters[i];
      Assert.assertEquals(expectedBaseCurrency, parsedCurrencyPair.base.toString());
      Assert.assertEquals(expectedCounterCurrency, parsedCurrencyPair.counter.toString());
    }
  }
}
