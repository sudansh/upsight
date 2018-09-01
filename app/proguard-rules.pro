# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontobfuscate

# Upsight
-keep class com.upsight.android.** { *; }
-keep interface com.upsight.android.** { *; }
-dontwarn com.upsight.android.UpsightContext
-dontwarn com.upsight.android.marketing.internal.vast.VastContentModel

# Unity
-keep class com.unity3d.** { *; }
-keep class bitter.jnibridge.** { *; }
-keep class org.fmod.** { *; }

# Upsight mediation
-dontwarn com.upsight.mediation.**
-keep class com.upsight.mediation.** { *; }
-keep interface com.upsight.mediation.** { *; }
-keep class com.google.android.gms.ads.identifier.** { *; }
-keep interface com.google.android.gms.ads.identifier.** { *; }

# Mediation:AdColony
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}
-keepclassmembers class com.adcolony.sdk.ADCNative** {*;}
-keep class com.adcolony.sdk.** { *; }
-dontwarn com.adcolony.sdk.AdColonyPubServicesPushRegIdListenerService
-dontwarn android.app.Activity

# Mediation:AppLovin
-keep class com.applovin.** { *; }
-dontwarn com.applovin.**

# Mediation:Mopub
-keepclassmembers class com.mopub.** { public *; }
-keep public class com.mopub.**
-keep public class android.webkit.JavascriptInterface {}
-keep class * extends com.mopub.mobileads.CustomEventInterstitial {}
-keep class * extends com.mopub.mobileads.CustomEventRewardedVideo {}
-keep class com.google.android.gms.common.GooglePlayServicesUtil { *; }
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient { *; }
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info { *; }
-dontwarn com.google.android.gms.**
-dontwarn org.apache.http.**
-dontwarn com.mopub.volley.toolbox.**

# Mediation:UnityAds
-keepattributes SourceFile,LineNumberTable
-keepattributes JavascriptInterface
-keep class android.webkit.JavascriptInterface { *; }
-keep class com.unity3d.ads.** { *; }

# Mediation:Vungle
-keep class com.vungle.** { *; }
-keep class javax.inject.*
-dontwarn com.vungle.**

# Mediation:Ironsource
-keep class com.ironsource.adapters.** { *; }
-keep class com.moat.** { public protected private *; }
-keepclassmembers class com.ironsource.sdk.controller.IronSourceWebView$JSInterface {
    public *;
}
-dontwarn com.ironsource.**
-dontwarn com.moat.**

# Mediation:AdMob (optional)
-keep public class com.google.android.gms.ads.** { public *; }
-keep public class com.google.ads.** { public *; }

# Mediation:Tapjoy (optional)
-keep class com.tapjoy.** { *; }
-keep class com.moat.** { *; }
-keepattributes JavascriptInterface
-keepattributes *Annotation*
-dontwarn com.tapjoy.**

# Mediation:Chartboost (optional)
-keep class com.chartboost.** { *; }

# HttpHeaders
-dontwarn com.google.common.net.HttpHeaders

# Dagger
-dontwarn dagger.**

# Gson
-keepattributes Signature
-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

# Rx
-dontwarn sun.misc.**
-keep class rx.schedulers.Schedulers {
    public static <methods>;
}
-keep class rx.schedulers.ImmediateScheduler {
    public <methods>;
}
-keep class rx.schedulers.TestScheduler {
    public <methods>;
}
-keep class rx.schedulers.Schedulers {
    public static ** test();
}
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
    long producerIndex;
    long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    long producerNode;
    long consumerNode;
}
