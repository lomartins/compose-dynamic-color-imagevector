# Dynamic Color ImageVector
Simple example how you can use dynamic color image vector in your app.

![Dynamic Color Image Vector Demo](./images/demo.gif)

## How to use

### 1. Create a xml image vector
The content of the XML will be used as base to create the needed kotlin code.

```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="1058dp"
    android:height="1058dp"
    android:viewportWidth="1058"
    android:viewportHeight="1058">
  <path
      android:pathData="M0,0h1058v1058h-1058z"
      android:fillColor="#44475A"/>
  <path
      android:pathData="M112,884.1l446.4,-773.1l108.5,62.6l-446.4,773.1z"
      android:fillColor="#F8F8F2"/>
  <path
      android:pathData="M735,523.7L918.3,841.2H551.8L735,523.7Z"
      android:fillColor="#50FA7B"/>
</vector>
```

### 2. Create your dynamic color image vector
Use the pathData from your image vector using the `ImageVector.Builder`.
Each path will be added to the `ImageVector` with the color you set.

```kotlin
fun makeIcon(
    viewportWidth: Float = 1058f,
    viewportHeight: Float = 1058f,
    defaultWidth: Dp = 1058.dp,
    defaultHeight: Dp = 1058.dp,
    backgroundColor: Color = Color(0xFF44475A),
    primaryColor: Color = Color(0xFF50FA7B),
    secondaryColor: Color = Color(0xFFF8F8F2),
): ImageVector {

    return ImageVector.Builder(
        defaultWidth = defaultWidth,
        defaultHeight = defaultHeight,
        viewportWidth = viewportWidth,
        viewportHeight = viewportHeight,
    ).run {
        addPath(
            pathData = addPathNodes("M0,0h1058v1058h-1058z"),
            fill = SolidColor(backgroundColor)
        )
        addPath(
            pathData = addPathNodes("M112,884.1l446.4,-773.1l108.5,62.6l-446.4,773.1z"),
            fill = SolidColor(secondaryColor)
        )
        addPath(
            pathData = addPathNodes("M735,523.7L918.3,841.2H551.8L735,523.7Z"),
            fill = SolidColor(primaryColor)
        )
        build()
    }
}
```

### 3. Use your dynamic color image vector

```kotlin
Image(
    imageVector = makeIcon(
        backgroundColor = dynamicBackgroundColor,
        primaryColor = dynamicPrimaryColor,
        secondaryColor = dynamicSecondaryColor,
    ),
    contentDescription = "Dynamic Color ImageVector",
    modifier = Modifier
        .size(200.dp)
        .padding(16.dp)
)
```


### Using colors from your theme
You can also use MaterialTheme colors to create your dynamic color image vector.
Just turn your function into a composable function and use the `MaterialTheme.colors` to get the colors.
```kotlin
@Composable
fun makeIcon(
    ...
    backgroundColor: Color = Color(0xFF44475A),
    primaryColor: Color = MaterialTheme.colors.primary,
    secondaryColor: Color = MaterialTheme.colors.secondary,
): ImageVector {
    ...
}
```