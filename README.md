# Cloudover

Cloudover is an Android library that simplifies fetching weather data using Retrofit. With just two lines of code, you can integrate real-time weather data into your Android application.

## Getting Started

### Step 1: Add the JitPack repository

Add the following code to your root `build.gradle` at the end of the repositories section:

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```


### Step 2: Add the Cloudover dependency

Add the following code to your root `build.gradle`

```groovy
dependencies {
    implementation 'com.github.yyuvraj54:CloudoverLibrary:Tag'
}
```

## Example

```groovy
val cloudOver = Cloudover("your_api_key")
cloudOver.getData("New York")
```
### Response

```groovy
Response Body
{
    "location": {
        "name": "London",
        "region": "City of London, Greater London",
        "country": "United Kingdom",
        "lat": 51.52,
        "lon": -0.11,
        "tz_id": "Europe/London",
        "localtime_epoch": 1724015140,
        "localtime": "2024-08-18 22:05"
    },
    "current": {
        "last_updated_epoch": 1724014800,
        "last_updated": "2024-08-18 22:00",
        "temp_c": 18.2,
        "temp_f": 64.8,
        "is_day": 0,
        "condition": {
            "text": "Clear",
            "icon": "//cdn.weatherapi.com/weather/64x64/night/113.png",
            "code": 1000
        },
        "wind_mph": 5.6,
        "wind_kph": 9.0,
        "wind_degree": 320,
        "wind_dir": "NW",
        "pressure_mb": 1017.0,
        "pressure_in": 30.03,
        "precip_mm": 0.0,
        "precip_in": 0.0,
        "humidity": 64,
        "cloud": 0,
        "feelslike_c": 18.2,
        "feelslike_f": 64.8,
        "windchill_c": 18.6,
        "windchill_f": 65.6,
        "heatindex_c": 18.6,
        "heatindex_f": 65.6,
        "dewpoint_c": 9.5,
        "dewpoint_f": 49.1,
        "vis_km": 10.0,
        "vis_miles": 6.0,
        "uv": 1.0,
        "gust_mph": 9.0,
        "gust_kph": 14.4
    }
}
```





