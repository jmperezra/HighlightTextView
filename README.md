# HighlightTextView
[![](https://jitpack.io/v/jmperezra/HighlightTextView.svg)](https://jitpack.io/#jmperezra/HighlightTextView) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

**HighlightTextView** es un componente que permite resaltar palabras o añadir eventos al contenido de un TextView. 
Una vez establecido el contenido en un TextView, **HighlightTextView** te permite de una forma sencilla, añadir estilos y eventos personalizados en múltiples cadenas.
**HightlightTextView** te evita tener que estar trabajando con SpannableString para tener que establecer los distintos estilos en un TextView. 

#### Sus características principales son:
* Permite resaltar una cadena.
* Permite añadir el evento onclick en la cadena elegida.
* Permite personalizar con un estilo la cadena a resaltar.
* Permite añadir múltiples estilos.
* Permite empezar a buscar la cadena en una posición determinada.
* Permite establecer el número de ocurrencias que se quieren resaltar.
* Permite ignorar mayúsculas y minúsculas.
* Posibilidad de configurarse a través de xml o por código.
* Trabaja con TextView personalizados.

#### Definición de opciones disponibles
#### XML
#
Desde XML sólo podemos definir una cadena a resaltar. No se pueden definir eventos.
Atributo Xml | Definición
------------ | -------------
htv_highlight_text | Cadena a buscar en el texto del TextView.  Valor obligatorio.
htv_start_position_occurrence | Posición desde donde empieza a buscar. Posición 0 es el inicio. Por defecto, posición 0.
htv_limit | Número de palabras que se quieren encontrar. Por defecto, son todas.
htv_highlight_style | Estilo de la cadena a buscar. Ej: R.style.Title. Por defecto, Bold.
htv_ignorecase | Si se ignora mayúsculas y minúsculas. Por defecto false.

#### Programación
#
Desde programación podemos definir múltiples cadenas a resaltar. Para ello hay  que establecer los estados en un ViewModel.
Atributo ViewModel | Definición
------------ | -------------
textToHighlight | Cadena a buscar en el texto del TextView.  Valor obligatorio.
clickHighlightText | Función que se ejecuta tras hacer click en la cadena a resaltar.
startPositionOccurence | Posición desde donde empieza a buscar. Posición 0 es el inicio. Por defecto, posición 0.
limit | Número de palabras que se quieren encontrar. Por defecto, son todas.
styleHighlightText | Estilo de la cadena a buscar. Ej: R.style.Title. Por defecto, Bold.
ignoreCase | Si se ignora mayúsculas y minúsculas. Por defecto false.

## Ejemplos
#
#### Ejemplo 1. Configuración mínima desde XML.
Link al código: **[Ejemplo 1]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/res/layout/view_example_01.xml)
```
<com.jmperezra.highlighttextview.HighlightTextView
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:text="@string/text_lorem_ipsum"
      app:htv_highlight_text="@string/example1_text_to_highlight"
      style="@style/Example"
      />
```
#### Ejemplo 2. Configuración completa desde XML.
Link al código: **[Ejemplo 2]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/res/layout/view_example_02.xml)
```
<com.jmperezra.highlighttextview.HighlightTextView
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:text="@string/text_lorem_ipsum"
      app:htv_highlight_text="@string/example2_text_to_highlight"
      app:htv_ignorecase="false"
      app:htv_limit="1"
      app:htv_start_position_occurrence="0"
      style="@style/Example"
      app:htv_highlight_style="@style/Bold"
      />
```
#### Ejemplo 3. Configuración desde XML donde se limita a 2 las palabras a resaltar (htv_limit = 2).
Link al código: **[Ejemplo 3]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/res/layout/view_example_03.xml)
```
<com.jmperezra.highlighttextview.HighlightTextView
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:text="@string/text_lorem_ipsum"
      app:htv_highlight_text="@string/example3_text_to_highlight"
      app:htv_ignorecase="false"
      app:htv_limit="2"
      app:htv_start_position_occurrence="0"
      style="@style/Example"
      app:htv_highlight_style="@style/Bold"
      />
```
#### Ejemplo 3. Configuración desde XML donde se limita a 2 las palabras a resaltar (htv_limit = 2).
Link al código: **[Ejemplo 3]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/res/layout/view_example_03.xml)
```
<com.jmperezra.highlighttextview.HighlightTextView
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:text="@string/text_lorem_ipsum"
      app:htv_highlight_text="@string/example3_text_to_highlight"
      app:htv_ignorecase="false"
      app:htv_limit="2"
      app:htv_start_position_occurrence="0"
      style="@style/Example"
      app:htv_highlight_style="@style/Bold"
      />
```
#### Ejemplo 4. Configuración desde XML donde se limita a 2 las palabras a resaltar (htv_limit = 2) y se inicia la búsqueda desde el inicio (htv_start_position_occurrence = 0).
Link al código: **[Ejemplo 4]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/res/layout/view_example_04.xml)
```
<com.jmperezra.highlighttextview.HighlightTextView
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:text="@string/text_lorem_ipsum"
      app:htv_highlight_text="@string/example4_text_to_highlight"
      app:htv_ignorecase="false"
      app:htv_start_position_occurrence="0"
      style="@style/Example"
      app:htv_highlight_style="@style/Bold"
      />
```
#### Ejemplo 5. Configuración desde XML donde se deja por defecto las ocurrencias a encontrar (todas) y se establece la ocurrencia inical en la segunda palabra (htv_start_position_occurrence="1"").
Link al código: **[Ejemplo 5]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/res/layout/view_example_05.xml)
```
<com.jmperezra.highlighttextview.HighlightTextView
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:text="@string/text_lorem_ipsum"
      app:htv_highlight_text="@string/example5_text_to_highlight"
      app:htv_ignorecase="false"
      app:htv_start_position_occurrence="1"
      style="@style/Example"
      app:htv_highlight_style="@style/Bold"
      />
```
#### Ejemplo 6. Configuración desde XML donde se establece un estilo (htv_highlight_style).
Link al código: **[Ejemplo 6]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/res/layout/view_example_06.xml)
```
<com.jmperezra.highlighttextview.HighlightTextView
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:text="@string/text_lorem_ipsum"
      app:htv_highlight_text="@string/example6_text_to_highlight"
      style="@style/Example"
      app:htv_highlight_style="@style/Link"
      />
```
#### Ejemplo 7. Configuración desde XML donde se ignoran las mayúsculas (htv_ignorecase).
Link al código: **[Ejemplo 7]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/res/layout/view_example_07.xml)
```
<com.jmperezra.highlighttextview.HighlightTextView
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:text="@string/text_lorem_ipsum"
      app:htv_highlight_text="@string/example7_text_to_highlight"
      app:htv_ignorecase="true"
      style="@style/Example"
      />
```

#### Ejemplo 8. Configuración mínima desde código (Kotlin).
Link al código: **[Ejemplo 8]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/java/com/jmperezra/samplehighlighttextview/MainKotlin.kt)
```
private fun initExample8() {
		htvExample8.renderHighlightViewModels(mutableListOf(buildMinConfigViewModel()))
}

private fun buildMinConfigViewModel() =
			HighlightTextViewModel(getText(R.string.example8_text_to_highlight).toString(),
			                       clickHighlightText = None)
    
```

#### Ejemplo 9. Configuración completa desde código (Kotlin).
Link al código: **[Ejemplo 9]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/java/com/jmperezra/samplehighlighttextview/MainKotlin.kt)
```
private fun initExample9() {
		htvExample9.renderHighlightViewModels(mutableListOf(buildFullConfigViewModel()))
}

private fun buildFullConfigViewModel() =
			HighlightTextViewModel(getText(R.string.example9_text_to_highlight).toString(),
			                       R.style.Link,
			                       None,
			                       0,
			                       HighlightTextLimit.All(),
			                       true)
    
```

#### Ejemplo 10. Configuración completa desde código con evento (Kotlin).
Link al código: **[Ejemplo 10]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/java/com/jmperezra/samplehighlighttextview/MainKotlin.kt)
```
private fun initExample10() {
		htvExample10.renderHighlightViewModels(mutableListOf(buildWithEventConfigViewModel()))
}

private fun buildWithEventConfigViewModel() =
			HighlightTextViewModel(getText(R.string.example10_text_to_highlight).toString(),
			                       R.style.Link,
			                       Eval { showHelloWorldToast() }.some(),
			                       0,
			                       HighlightTextLimit.NumLimit(1),
			                       true)

private fun showHelloWorldToast() {
		Toast.makeText(this, R.string.hello_world, Toast.LENGTH_SHORT).show()
	}
    
```

#### Ejemplo 11. Configuración con múltiples Highlight (Kotlin).
Link al código: **[Ejemplo 11]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/java/com/jmperezra/samplehighlighttextview/MainKotlin.kt)
```
private fun initExample11() {
		htvExample11.renderHighlightViewModels(mutableListOf(buildRedViewModel(),
		                                                     buildGreenViewModel(),
		                                                     buildOrangeViewModel()))
}

private fun buildRedViewModel() =
			HighlightTextViewModel(getText(R.string.example11_text_to_highlight_1).toString(),
			                       R.style.Red,
			                       Eval { showRedToast() }.some(),
			                       0,
			                       HighlightTextLimit.All(),
			                       true)

private fun buildGreenViewModel() =
    HighlightTextViewModel(getText(R.string.example11_text_to_highlight_2).toString(),
                           R.style.Green,
                           None,
                           0,
                           HighlightTextLimit.NumLimit(1),
                           true)

private fun buildOrangeViewModel() =
    HighlightTextViewModel(getText(R.string.example11_text_to_highlight_3).toString(),
                           R.style.Orange,
                           Eval { showOrangeToast() }.some(),
                           0,
                           HighlightTextLimit.First(),
                           true)
                           
private fun showOrangeToast() {
		Toast.makeText(this, R.string.hello_orange_world, Toast.LENGTH_SHORT).show()
}

private fun showRedToast() {
  Toast.makeText(this, R.string.hello_red_world, Toast.LENGTH_SHORT).show()
}
    
```

#### Ejemplo 12. Configuración con un Custom  TextView (Kotlin).
Link al código: **[Ejemplo 12]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/res/layout/view_example_12.xml)
```
<com.jmperezra.samplehighlighttextview.CustomTextView
      android:id="@+id/htvExample11"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:text="@string/text_lorem_ipsum"
      app:htv_highlight_text="@string/example12_text_to_highlight"
      style="@style/Example"
      />
```

#### Ejemplo 8. Configuración mínima desde código (Java).
Link al código: **[Ejemplo 8]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/java/com/jmperezra/samplehighlighttextview/MainJava.java)
```
private void initExample8() {
        HighlightTextView htv = findViewById(R.id.htvExample8);
        htv.renderHighlightViewModels(Collections.singletonList(buildMinConfigViewModel()));
}

private HighlightTextViewModel buildMinConfigViewModel() {
        return new HighlightTextViewModel(getText(R.string.example8_text_to_highlight).toString(),
                R.style.Link, None.INSTANCE, 0, new HighlightTextLimit.Default(), false);
}
    
```

#### Ejemplo 9. Configuración completa desde código (Java).
Link al código: **[Ejemplo 9]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/java/com/jmperezra/samplehighlighttextview/MainJava.java)
```
private void initExample9() {
        HighlightTextView htv = findViewById(R.id.htvExample9);
        htv.renderHighlightViewModels(Collections.singletonList(buildFullConfigViewModel()));
}

private HighlightTextViewModel buildFullConfigViewModel() {
        return new HighlightTextViewModel(getText(R.string.example9_text_to_highlight).toString(),
                R.style.Link, None.INSTANCE, 0, new HighlightTextLimit.All(), true);
}
    
```
#### Ejemplo 10. Configuración completa desde código con evento (Java).
Link al código: **[Ejemplo 10]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/java/com/jmperezra/samplehighlighttextview/MainJava.java)
```
private void initExample10() {
        HighlightTextView htv = findViewById(R.id.htvExample10);
        htv.renderHighlightViewModels(Collections.singletonList(buildWithEventConfigViewModel()));
}

private HighlightTextViewModel buildWithEventConfigViewModel() {
        return new HighlightTextViewModel(getText(R.string.example10_text_to_highlight).toString(),
                R.style.Link, new Some<>(new Eval(view -> {
                    showHelloWorldToast();
                    return null;
        })), 0, new HighlightTextLimit.NumLimit(1), true);
}

private void showHelloWorldToast() {
        Toast.makeText(this, R.string.hello_world, Toast.LENGTH_SHORT).show();
}
    
```

#### Ejemplo 11. Configuración con múltiples Highlight (Kotlin).
Link al código: **[Ejemplo 11]** (https://github.com/jmperezra/HighlightTextView/blob/master/app/src/main/java/com/jmperezra/samplehighlighttextview/MainJava.java)
```
private void initExample11() {
        HighlightTextView htv = findViewById(R.id.htvExample11);
        List<HighlightTextViewModel> viewModels = new ArrayList<>();
        viewModels.add(buildRedViewModel());
        viewModels.add(buildGreenViewModel());
        viewModels.add(buildOrangeViewModel());
        htv.renderHighlightViewModels(viewModels);
}
    
private HighlightTextViewModel buildRedViewModel() {
        return new HighlightTextViewModel(
                getText(R.string.example11_text_to_highlight_1).toString(), R.style.Red,
                new Some<>(new Eval(view -> {
                    showRedToast();
                    return null;
                })), 0, new HighlightTextLimit.All(), true);
}

private HighlightTextViewModel buildGreenViewModel() {
    return new HighlightTextViewModel(
            getText(R.string.example11_text_to_highlight_2).toString(),
            R.style.Green,
            None.INSTANCE,
            0, new HighlightTextLimit.NumLimit(1), true);
}

private HighlightTextViewModel buildOrangeViewModel() {
    return new HighlightTextViewModel(
            getText(R.string.example11_text_to_highlight_3).toString(),
            R.style.Orange,
            new Some<>(new Eval(view -> {
                showOrangeToast();
                return null;
            })),
            0, new HighlightTextLimit.First(), true);
}

private void showOrangeToast() {
        Toast.makeText(this, R.string.hello_orange_world, Toast.LENGTH_SHORT).show();
}

private void showRedToast() {
    Toast.makeText(this, R.string.hello_red_world, Toast.LENGTH_SHORT).show();
}
```
