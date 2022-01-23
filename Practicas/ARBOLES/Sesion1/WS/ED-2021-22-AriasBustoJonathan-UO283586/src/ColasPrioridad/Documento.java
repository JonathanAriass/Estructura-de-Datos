package ColasPrioridad;

public class Documento implements Comparable<Documento>{

		private int prioridad;
		private String nombre;
		private String descripcion;
		
		public Documento(int prioridad, String nombre, String descripcion) {
			this.prioridad = prioridad;
			this.nombre = nombre;
			this.descripcion = descripcion;
		}
		
		public int getPrioridad() {
			return prioridad;
		}

		public void setPrioridad(int prioridad) {
			this.prioridad = prioridad;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		@Override
		public int compareTo(Documento p) {
			if (this.getPrioridad() < p.getPrioridad()) {
				return -1;
			} else if (this.getPrioridad() > p.getPrioridad()) {
				return 1;
			} else {
				return 0;
			}
		}
		
		@Override
		public String toString() {
			return nombre;
		}
		
		@Override
		public boolean equals(Object p) {
			if (p == this) return true;
			
			if (!(p instanceof Documento)) return false;
			
			Documento pAux = (Documento)p;
			
			return pAux.getNombre() == this.getNombre() && pAux.getPrioridad() == this.getPrioridad() && 
					pAux.getDescripcion() == this.getDescripcion();
		}
	
}
