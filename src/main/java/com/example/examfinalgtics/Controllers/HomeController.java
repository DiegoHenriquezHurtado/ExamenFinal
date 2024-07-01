package com.example.examfinalgtics.Controllers;

import com.example.examfinalgtics.Entitys.Juegos;
import com.example.examfinalgtics.Repository.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
public class HomeController {

    @Autowired
    private DistribuidorasRepository distribuidorasRepository;

    @Autowired
    private EditorasRepository editorasRepository;

    @Autowired
    private GenerosRepository generosRepository;

    @Autowired
    private JuegosRepository juegosRepository;

    @Autowired
    private PaisesRepository paisesRepository;

    @Autowired
    private PlataformaRepository plataformaRepository;


    @GetMapping("/api/orders")
    public ResponseEntity<HashMap<String,Object>> listarJuegos(){

        HashMap<String, Object> responseJson = new HashMap<>();
        List<Juegos> listaJuegos = juegosRepository.findAll();

        responseJson.put("result","success");
        responseJson.put("data",listaJuegos);

        return ResponseEntity.ok(responseJson);
    }

    @PostMapping("/api/orders")
    public ResponseEntity<HashMap<String,Object>> crearJuego(@RequestBody Juegos juego,
                                                             @RequestParam(value = "fetchId" ,required = false) boolean fetchId){
        HashMap<String,Object> responseJson = new HashMap<>();
        juegosRepository.save(juego);
        if(fetchId){
            responseJson.put("result","success");
            responseJson.put("new_id",juego.getIdJuego());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);
    }

    @PutMapping("/api/orders")

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String,String>> gestionExcepcion(HttpServletRequest request){
        HashMap<String,String> responseMap = new HashMap<>();
        if(request.getMethod().equals("POST")){
            responseMap.put("estado","error");
            responseMap.put("msg","parametros incorrectos");
        }
        return ResponseEntity.badRequest().body(responseMap);
    }
}
