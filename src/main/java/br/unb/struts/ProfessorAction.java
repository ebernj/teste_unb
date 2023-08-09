package br.unb.struts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import br.unb.dao.ProfessorDAO;
import br.unb.dominio.Professor;

public class ProfessorAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("ProfessorAction::execute");
    	ProfessorForm professorForm = (ProfessorForm) form;
        ProfessorDAO professorDAO = new ProfessorDAO();
        
        String method = request.getParameter("method");
        System.out.println("ProfessorAction::execute::method "+ method);
        if (method != null && !method.isEmpty()) {

        	ActionMessages errors = new ActionErrors();
            if (professorForm.getNome() == null || professorForm.getNome().trim().isEmpty()) {
                errors.add("nome", new ActionMessage("error.nome.required"));
            }

            if (!errors.isEmpty()) {
                saveErrors(request, errors);
            }
        	
        	
        	switch (method) {
                case "salvar":
                    Professor professor = new Professor(professorForm.getNome());
                    professorDAO.salvar(professor);
                    break;
                case "editar":
                	Long id = Long.valueOf(request.getParameter("id"));
                    professor = professorDAO.buscarPorId(id);
                    professorForm.setId(professor.getId());
                    professorForm.setNome(professor.getNome());
                    break;
                case "atualizar":
                    professor = new Professor(professorForm.getId(), professorForm.getNome());
                    professorDAO.atualizar(professor);
                    break;
                case "excluir":
                	id = Long.valueOf(request.getParameter("id"));
                    professorDAO.excluir(id);
                    professorForm.setId(0L);
                    break;
            }
        }

        List<Professor> professores = professorDAO.listarTodos();
        request.setAttribute("professores", professores);

        return mapping.findForward("success");
    }
}
