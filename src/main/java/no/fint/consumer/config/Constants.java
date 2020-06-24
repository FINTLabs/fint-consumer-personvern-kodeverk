
package no.fint.consumer.config;

public enum Constants {
;

    public static final String COMPONENT = "personvern-kodeverk";
    public static final String COMPONENT_CONSUMER = COMPONENT + " consumer";
    public static final String CACHE_SERVICE = "CACHE_SERVICE";

    
    public static final String CACHE_INITIALDELAY_BEHANDLINGSGRUNNLAG = "${fint.consumer.cache.initialDelay.behandlingsgrunnlag:900000}";
    public static final String CACHE_FIXEDRATE_BEHANDLINGSGRUNNLAG = "${fint.consumer.cache.fixedRate.behandlingsgrunnlag:900000}";
    

}
