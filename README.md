# press-article

Aplikacja udostępnia wymienione poniżej endpointy:</br>

/getall/sorteddesc #1       : zwraca listę artykułów posortowanych malejąco według daty publikacji.</br>

/get/{id}                #1: zwracający pojedynczy artykuł po id.</br>
/findby/{keyWord}        #1: zwracający listę wszystkich artykułów prasowych po słowie kluczowym zawartym w tytule lub treści publikacji.</br>
/save saveArticle        #1: pozwalający na zapis artykułu prasowego. W ciele żądania zawieramy obiekt Article w formacie JSON jak w przykładzie poniżej.
                             Data zapisu oraz publikacji artykułu będzie wprowadzona automatycznie. Id artykułu jest zawsze generowane przez bazę danych.</br>
/update/{author}/{title} #1: aktualizacja istniejącego artykułu prasowego. Po wprowadzeniu aktualizacji data publikacji zostanie zmieniona automatycznie.</br>  
/delete/{author}/{title} #1: usuwanie wybranego artykułu prasowego.</br>

Warstwą zapisu danych jest baza MySql. Po uruchomieniu aplikacji baza będzie pusta dlatego wymagane jest wypełnić ją danymi przesyłając artykuły przez
dostępny endpoint /save. W trakcie zapisu imię autora nie może mieć mniej niż 3 litery a także nie może być puste. Tytuł a także zawartość artykułu
nie mogą być puste. Artykuł musi mieć więcej niż 100 znaków.
Artykuły w bazie są identyfikowane za pomocą id oraz unikatowego klucza który tworzą dwie kolumny w tabeli a są nimi autor i tytuł. Dzięki temu
artykuł posiada autora i tytuł które nie mogą się powtórzyć. Na przykład autor: Kowalski tytuł: globalizacja , obie w takim zestawieniu nie mogą
się powtórzyć.</br>
</br>
Obiekt Article JSON :

{
        
        "author": "Kowalski",
        "title": "Wybuchowe wynalazki",
        "content": "tutaj treść artykułu większa niż 100 znaków",
        "source": "Zoo Central Park" 
}

source: określa nazwę wydawnictwa/prasy</br>
title: nazwa artykułu</br>
content : treść artykułu</br>
autor: autor artykułu</br>

