// package com.ipartek.formacion.login.controller;
//
// import java.io.IOException;
//
// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletConfig;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
//
// import com.ipartek.formacion.login.servicios.ServiceUsuario;
// import com.ipartek.formacion.vehiculo.pojo.Mensaje;
// import com.ipartek.formacion.vehiculo.pojo.Vehiculo;
//
/// **
// * Servlet implementation class VehiculoCRUDController
// */
// @WebServlet("/login")
// public class UsuarioController extends HttpServlet {
// private static final long serialVersionUID = 1L;
//
// // vistas
//
// private static final String VIEW_FORM = "login.jsp";
// // TODO view list
// private static final String VIEW_LIST = "login.jsp";
//
// // otros
// private static ServiceUsuario service;
//
// /**
// * Solo se hace en la primera peticion al controlador
// */
// @Override
// public void init(ServletConfig config) throws ServletException {
//
// super.init(config);
// // service = VehiculoServiceObjectString.getInstance();
// service = ServiceUsuario.getInstance();
// }
//
// @Override
// protected void service(HttpServletRequest req, HttpServletResponse resp)
// throws ServletException, IOException {
// // Esto se hace antes de realizar doGet o doPost
// super.service(req, resp);
// // Esto se hace despues de realizar doGet o doPost"
// }
//
// /**
// * Destruimos
// */
// @Override
// public void destroy() {
// // TODO Auto-generated method stub
// super.destroy();
// service = null;
// }
//
// @Override
// protected void doGet(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {
// String op = "";
// long id = -1;
// Mensaje msj = null;
// RequestDispatcher dispatcher = null;
//
// try {
// // incializar mensaje
// msj = new Mensaje();
//
// // buscar operacion a realizar
// op = request.getParameter("op");
// if (op == null) {
// op = OP_LISTAR;
// }
//
// switch (op) {
//
// case OP_VER_NUEVO:
// request.setAttribute("vehiculo", new Vehiculo());
// dispatcher = request.getRequestDispatcher(VIEW_FORM);
// msj = null;
// break;
//
// case OP_VER_DETALLE:
// id = Long.valueOf(request.getParameter("id"));
// request.setAttribute("vehiculo", service.getById(id));
// dispatcher = request.getRequestDispatcher(VIEW_FORM);
// msj = null;
// break;
//
// case OP_GUARDAR:
// try {
// // recoger parametros
// id = Long.valueOf(request.getParameter("id"));
// String pModelo = request.getParameter("modelo");
// int pPlazas = Integer.valueOf(request.getParameter("plazas"));
// // Float pPotencia =
// // Float.valueOf(request.getParameter("potencia"));
// String pPotencia2 = request.getParameter("potencia");
// // Float pDimensiones =
// // Float.valueOf(request.getParameter("dimensiones"));
// String pDimensiones2 = request.getParameter("dimensiones");
//
// // crear Vehiculo
// Vehiculo v = new Vehiculo();
// v.setId(id);
// v.setModelo(pModelo);
// v.setPlazas(pPlazas);
// v.setPotencia2(pPotencia2);
// v.setDimensiones2(pDimensiones2);
//
// // guardarlo o persistirlo en la bbdd
// boolean guardado = false;
// if (v.getId() == -1) {
// guardado = service.create(v);
// } else {
// guardado = service.update(v);
// }
//
// // compobar guardado y gestion Mensaje
// if (guardado) {
// msj.setClase(Mensaje.CLASE_SUCCESS);
// msj.setDescripcion("Vehiculo Guardado con Exito");
// } else {
// msj.setClase(Mensaje.CLASE_WARNING);
// msj.setDescripcion("No se ha podido Guardar el Vehiculo");
// }
//
// // cargar dispatch
// request.setAttribute("vehiculos", service.getAll());
// dispatcher = request.getRequestDispatcher(VIEW_LIST);
//
// } catch (Exception e) {
//
// // si es Vehiculo creado, volver a recuperarlo para mostrar
// // en formulario
// if (id != -1) {
// request.setAttribute("vehiculo", service.getById(id));
// } else {
// request.setAttribute("vehiculo", new Vehiculo());
// }
//
// msj.setDescripcion("Error:" + e.getMessage());
// dispatcher = request.getRequestDispatcher(VIEW_FORM);
// }
// break;
//
// case OP_ELIMINAR:
// id = Long.valueOf(request.getParameter("id"));
// if (service.delete(id)) {
// msj.setClase(Mensaje.CLASE_SUCCESS);
// msj.setDescripcion("Vehivulo Eliminado con Exito");
// } else {
// msj.setClase(Mensaje.CLASE_WARNING);
// msj.setDescripcion("No se ha podido Eliminar el Vehiculo");
// }
// request.setAttribute("vehiculos", service.getAll());
// dispatcher = request.getRequestDispatcher(VIEW_LIST);
// break;
//
// default:
// // listar
// request.setAttribute("vehiculos", service.getAll());
// dispatcher = request.getRequestDispatcher(VIEW_LIST);
// msj = null;
// break;
// }// end switch
//
// } catch (Exception e) {
// dispatcher = request.getRequestDispatcher(VIEW_LIST);
// msj.setDescripcion(e.getMessage());
// e.printStackTrace();
//
// } finally {
// request.setAttribute("msj", msj);
// dispatcher.forward(request, response);
// }
//
// }
//
// @Override
// protected void doPost(HttpServletRequest request, HttpServletResponse
// response)
// throws ServletException, IOException {
//
// doGet(request, response);
// }
//
// }
