

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <section>
            <div id ="tareasActivas">
                <h1>Tareas activas</h1>
                <c:foreach var="tarea" items="${tareasActivas}">
                    <div class="card mt-3" style="background-color: #D7D7D5">
                        <div class="card-body">
                            <h5>${tarea.titulo}</h5>
                            <p>${tarea.descripcion}</p>
                            <form method="POST" action="DashboardServlet">
                                
                            </form>
                        </div>
                    </div>
                </c:foreach>
            </div>
        </section>
    </body>
</html>
