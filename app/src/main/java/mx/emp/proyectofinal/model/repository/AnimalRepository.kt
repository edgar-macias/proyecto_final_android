package mx.emp.proyectofinal.model.repository

import mx.emp.proyectofinal.model.entities.Animal

class AnimalRepository {
    companion object{
        fun getTestAnimals():ArrayList<Animal>{
            val list = arrayListOf<Animal>()
            list.add(Animal(
                name="Colibrí",
                description = "Colibri es un género de aves apodiformes pertenecientes a la subfamilia" +
                        " de los troquilinos (Trochilinae). El género agrupa a cinco especies con una " +
                        "distribución principalmente neotropical.",
                uriImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Colibri_coruscans.jpg/800px-Colibri_coruscans.jpg",
                peso=0.02,
                gender = 'F'))
            list.add(Animal(
                name="Águila",
                description = "Águila es el nombre dado a las aves de presa, del orden de " +
                        "Accipitriformes, familia Accipitridae, subfamilia Buteoninae. ",
                uriImage = "https://upload.wikimedia.org/wikipedia/commons/5/58/Steinadler_Aquila_chrysaetos_closeup1_Richard_Bartz.jpg",
                peso=6.3,
                gender = 'M'))
            list.add(Animal(
                name="Ajolote",
                description = "El ajolote es una especie de anfibio caudado ambistomátido del género " +
                        "Ambystoma relacionado con la salamandra tigre",
                uriImage = "https://upload.wikimedia.org/wikipedia/commons/0/00/Axolotl_ganz.jpg",
                peso=60.0,
                gender = 'F'))
            list.add(Animal(
                name="Pitón",
                description = "Son una familia de serpientes constrictoras propias del paleotrópico. " +
                        "Otras fuentes consideran a este grupo una subfamilia de la familia de las boas",
                uriImage = "https://upload.wikimedia.org/wikipedia/commons/b/bb/Caramel_burmese_python.JPG",
                peso=100.0,
                gender = 'M'))
            list.add(Animal(
                name="Mono Araña",
                description = "Mono Araña o Ateles es un género de primates perteneciente a la familia Atelidae. " +
                        "El nombre Ateles hace referencia a la ausencia de un pulgar oponible " +
                        "en las especies del género; solo cuenta con apéndice vestigial.",
                uriImage = "https://upload.wikimedia.org/wikipedia/commons/8/84/Ateles_fusciceps_Colombia.JPG",
                peso=2.2, gender = 'F'))
            list.add(Animal(
                name="Jaguar",
                description = "El jaguar, yaguar es un carnívoro félido de la subfamilia de los Panterinos y género Panthera.",
                uriImage = "https://upload.wikimedia.org/wikipedia/commons/e/e9/Jaguar_%28Panthera_onca_palustris%29_female_Piquiri_River_2.JPG",
                peso=68.5,
                gender = 'F'))
            return list
        }
    }
}