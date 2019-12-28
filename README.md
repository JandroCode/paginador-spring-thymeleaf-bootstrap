# paginador-spring-thymeleaf-bootstrap
Paginador para proyectos con spring, thymeleaf y bootstrap

Para la realización de la paginación en un proyecto con spring y thymeleaf necesitamos crear dos clases específicas para realizarla
al margen de las otras clases que se necesiten para la realizaciónde un listado de registros de la base de datos o la realización
de un crud.

a) El primer paso sería hacer que el repositorio herede de PagingAndSortingRepository ( ya incluye todos los métodos que tiene
crud repository ya que hereda de él.

b) En la interfaz del servicio hay que modificar el método que retorne un listado de registros para que devulva un "Page" y por parámetro
pasarle una instancia de "Pageable"

  Ej.- public Page<Usuario> findAll(Pageable pageable);
  
c) Implementar este método en la clase que implemente el servicio

d) Implementar el controlador
    En el método de listar hay que pasar el parámetro de la página con un valor por defecto para esa página que sera 0)
    Hay que importar "Pageable" y crear una instancia e igualarla a un new de "PageRequest" que me pedirá por parámetro 
    el parámetro que le hemos introducido en el @PageRequest que será la página y el número de registros que queremos 
    introducir en cada página
    Crear el listado de registros paginale con el objeto de tipo "Page" y añadirlo al model.
    
e) Crear una clase para parametrizar cual es la primera página, la última, si hay página anterior, si hay página siguiente,...
  ( Esta clase es PageRender )
  Este Page Render hay que implmentarlo posteriormente en el controlador ( Crear el objeto y pasarlo a la vista )

f) Crear una clase para representar cada una de las páginas
  (Esta clase es PageItem)
  
g) Crear la vista
  ( Esta vista es "paginator-nav.html")
 
    
    




