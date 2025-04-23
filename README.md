# SensorApp

## Звіт
Детальний звіт про розробку цього застосунку, включаючи опис використаних технологій, архітектури, процесу розробки та результатів тестування, можна знайти за наступним посиланням:
[Посилання на звіт](https://github.com/sana23ok/SensorApp/blob/main/%D0%97%D0%B2%D1%96%D1%82%20%D0%9B%D0%A05.pdf)

## Основні класи програми

1.  [**`MainActivity`**](https://github.com/sana23ok/SensorApp/blob/main/app/src/main/java/com/example/sensorapp/MainActivity.kt)
    * Цей клас є головною Activity застосунку. Він відповідає за ініціалізацію інтерфейсу користувача, налаштування `ViewPager2` та `TabLayout` для навігації між фрагментами датчиків.

2.  [**`LightSensorFragment`**](https://github.com/sana23ok/SensorApp/blob/main/app/src/main/java/com/example/sensorapp/LightSensorFragment.kt)
    * Цей фрагмент відповідає за отримання та відображення даних з датчика освітленості. Він реєструє слухача датчика та оновлює відповідний `TextView` на екрані.

3. [**`OrientationFragment`**](https://github.com/sana23ok/SensorApp/blob/main/app/src/main/java/com/example/sensorapp/OrientationFragment.kt)
    * Цей фрагмент відповідає за отримання та відображення даних з датчика орієнтації (азимут, кут нахилу, крен). Він також реєструє слухача датчика та оновлює відповідні `TextView` на екрані.
