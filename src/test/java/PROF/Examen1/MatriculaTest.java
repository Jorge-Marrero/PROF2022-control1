package PROF.Examen1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

public class MatriculaTest {
	Matricula m2;
	Matricula m3;
	Asignatura a1 = mock(Asignatura.class);
	Asignatura a2 = mock(Asignatura.class);
	Asignatura a3 = mock(Asignatura.class);
	
	@Test
	public void lanza_excepcion_cuando_vector_nulo() throws Exception {
		assertThrows(Exception.class, () -> new Matricula(null));
	}
	
	@Test
	public void calcula_importe_matricula() throws Exception{
		when(a1.getImporte()).thenReturn(100.0);
		when(a2.getImporte()).thenReturn(350.5);
		when(a3.getImporte()).thenReturn(240.2);
		Vector<Asignatura> v1 = new Vector();
		v1.add(a1);
		v1.add(a2);
		v1.add(a3);
		m2 = new Matricula(v1);
		assertEquals(m2.getImporte(), 690.7);
	}
	
	@Test
	public void todas_asignaturas_recorridas() throws Exception{
		when(a1.getImporte()).thenReturn(100.0);
		when(a2.getImporte()).thenReturn(350.5);
		when(a3.getImporte()).thenReturn(240.2);
		Vector<Asignatura> v2 = new Vector<Asignatura>();
		v2.add(a1);
		v2.add(a2);
		v2.add(a3);
		m3 = new Matricula(v2);
		verify((a1), times(1)).getImporte();
		verify((a2), times(1)).getImporte();
		verify((a3), times(1)).getImporte();
	}
}
