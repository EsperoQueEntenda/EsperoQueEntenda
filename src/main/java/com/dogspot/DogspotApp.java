package com.dogspot;

import javax.swing.*;

public class DogspotApp {
    private static PetDAO petDAO = new PetDAO();
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();
    private static VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
    private static HistoricoDAO historicoDAO = new HistoricoDAO();

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    private static void exibirMenuPrincipal() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String[] opcoes = {"Cadastrar Pet", "Cadastrar Usuário", "Cadastrar Veterinário",
                "Cadastrar Histórico Médico", "Excluir Pet", "Alterar Informações do Pet",
                "Alterar Informações do Usuário", "Registrar Doença", "Registrar Vacina",
                "Registrar Peso", "Registrar Tratamento", "Visualizar Usuário",
                "Visualizar Pet", "Visualizar Histórico Médico", "Sair"};

        for (String opcao : opcoes) {
            JButton button = new JButton(opcao);
            button.setAlignmentX(JButton.CENTER_ALIGNMENT);
            button.addActionListener(e -> {
                switch (opcao) {
                    case "Cadastrar Pet":
                        cadastrarPet();
                        break;
                    case "Cadastrar Usuário":
                        cadastrarUsuario();
                        break;
                    case "Cadastrar Veterinário":
                        cadastrarVeterinario();
                        break;
                    case "Cadastrar Histórico Médico":
                        cadastrarHistoricoMedico();
                        break;
                    case "Excluir Pet":
                        excluirPet();
                        break;
                    case "Alterar Informações do Pet":
                        alterarInformacoesPet();
                        break;
                    case "Alterar Informações do Usuário":
                        alterarInformacoesUsuario();
                        break;
                    case "Registrar Doença":
                        registrarDoenca();
                        break;
                    case "Registrar Vacina":
                        registrarVacina();
                        break;
                    case "Registrar Peso":
                        registrarPeso();
                        break;
                    case "Registrar Tratamento":
                        registrarTratamento();
                        break;
                    case "Visualizar Usuário":
                        visualizarUsuario();
                        break;
                    case "Visualizar Pet":
                        visualizarPet();
                        break;
                    case "Visualizar Histórico Médico":
                        visualizarHistoricoMedico();
                        break;
                    case "Sair":
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                }
            });
            panel.add(button);
        }

        JOptionPane.showMessageDialog(null, panel, "Menu Principal", JOptionPane.PLAIN_MESSAGE);
    }

    private static void cadastrarPet() {
        try {
            String nome = JOptionPane.showInputDialog("Nome do Pet:");
            int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do Pet:"));
            String raca = JOptionPane.showInputDialog("Raça do Pet:");
            String origem = JOptionPane.showInputDialog("Origem do Pet:");
            double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso do Pet:"));

            Pet pet = new Pet(0, nome, idade, raca, origem, peso, new Historico(0));
            petDAO.inserirPet(pet);

            JOptionPane.showMessageDialog(null, "Pet cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar pet: " + e.getMessage());
        }
    }

    private static void cadastrarUsuario() {
        try {
            String nome = JOptionPane.showInputDialog("Nome do Usuário:");
            String contato = JOptionPane.showInputDialog("Contato do Usuário:");
            String endereco = JOptionPane.showInputDialog("Endereço do Usuário:");

            Usuario usuario = new Usuario(0, nome, contato, endereco);
            usuarioDAO.inserirUsuario(usuario);

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    private static void cadastrarVeterinario() {
        try {
            String nome = JOptionPane.showInputDialog("Nome do Veterinário:");
            String numeroRegistro = JOptionPane.showInputDialog("Número de Registro:");
            String especialidade = JOptionPane.showInputDialog("Especialidade:");

            Veterinario veterinario = new Veterinario(0, nome, numeroRegistro, especialidade);
            veterinarioDAO.inserirVeterinario(veterinario);

            JOptionPane.showMessageDialog(null, "Veterinário cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar veterinário: " + e.getMessage());
        }
    }

    private static void cadastrarHistoricoMedico() {
        try {
            int idPet = Integer.parseInt(JOptionPane.showInputDialog("ID do Pet:"));
            Pet pet = petDAO.buscarPetPorId(idPet);

            if (pet != null) {
                Historico historico = pet.getHistorico();
                historicoDAO.inserirHistorico(historico);
                JOptionPane.showMessageDialog(null, "Histórico médico cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Pet não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar histórico médico: " + e.getMessage());
        }
    }

    private static void excluirPet() {
        try {
            int idPet = Integer.parseInt(JOptionPane.showInputDialog("ID do Pet a ser excluído:"));
            petDAO.excluirPet(idPet);
            JOptionPane.showMessageDialog(null, "Pet excluído com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir pet: " + e.getMessage());
        }
    }

    private static void alterarInformacoesPet() {
        try {
            int idPet = Integer.parseInt(JOptionPane.showInputDialog("ID do Pet a ser alterado:"));
            Pet pet = petDAO.buscarPetPorId(idPet);

            if (pet != null) {
                String nome = JOptionPane.showInputDialog("Nome do Pet:", pet.getNome());
                int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do Pet:", pet.getIdade()));
                String raca = JOptionPane.showInputDialog("Raça do Pet:", pet.getRaca());
                String origem = JOptionPane.showInputDialog("Origem do Pet:", pet.getOrigem());
                double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso do Pet:", pet.getPeso()));

                pet.setNome(nome);
                pet.setIdade(idade);
                pet.setRaca(raca);
                pet.setOrigem(origem);
                pet.setPeso(peso);

                petDAO.atualizarPet(pet);
                JOptionPane.showMessageDialog(null, "Informações do pet alteradas com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Pet não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar informações do pet: " + e.getMessage());
        }
    }

    private static void alterarInformacoesUsuario() {
        try {
            int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("ID do Usuário a ser alterado:"));
            Usuario usuario = usuarioDAO.buscarUsuarioPorId(idUsuario);

            if (usuario != null) {
                String nome = JOptionPane.showInputDialog("Nome do Usuário:", usuario.getNome());
                String contato = JOptionPane.showInputDialog("Contato do Usuário:", usuario.getContato());
                String endereco = JOptionPane.showInputDialog("Endereço do Usuário:", usuario.getEndereco());

                usuario.setNome(nome);
                usuario.setContato(contato);
                usuario.setEndereco(endereco);

                usuarioDAO.atualizarUsuario(usuario);
                JOptionPane.showMessageDialog(null, "Informações do usuário alteradas com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar informações do usuário: " + e.getMessage());
        }
    }

    // Métodos de Registro
    private static void registrarDoenca() {
        try {
            int idPet = Integer.parseInt(JOptionPane.showInputDialog("ID do Pet:"));
            String doenca = JOptionPane.showInputDialog("Doença:");

            Pet pet = petDAO.buscarPetPorId(idPet);
            if (pet != null) {
                pet.getHistorico().adicionarDoenca(doenca);
                historicoDAO.atualizarHistorico(pet.getHistorico());
                JOptionPane.showMessageDialog(null, "Doença registrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Pet não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar doença: " + e.getMessage());
        }
    }

    private static void registrarVacina() {
        try {
            int idPet = Integer.parseInt(JOptionPane.showInputDialog("ID do Pet:"));
            String vacina = JOptionPane.showInputDialog("Vacina:");

            Pet pet = petDAO.buscarPetPorId(idPet);
            if (pet != null) {
                pet.getHistorico().adicionarVacina(vacina);
                historicoDAO.atualizarHistorico(pet.getHistorico());
                JOptionPane.showMessageDialog(null, "Vacina registrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Pet não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar vacina: " + e.getMessage());
        }
    }

    private static void registrarPeso() {
        try {
            int idPet = Integer.parseInt(JOptionPane.showInputDialog("ID do Pet:"));
            double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso:"));

            Pet pet = petDAO.buscarPetPorId(idPet);
            if (pet != null) {
                pet.getHistorico().adicionarPeso(peso);
                historicoDAO.atualizarHistorico(pet.getHistorico());
                JOptionPane.showMessageDialog(null, "Peso registrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Pet não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar peso: " + e.getMessage());
        }
    }

    private static void registrarTratamento() {
        try {
            int idPet = Integer.parseInt(JOptionPane.showInputDialog("ID do Pet:"));
            String tratamento = JOptionPane.showInputDialog("Tratamento:");

            Pet pet = petDAO.buscarPetPorId(idPet);
            if (pet != null) {
                pet.getHistorico().adicionarTratamento(tratamento);
                historicoDAO.atualizarHistorico(pet.getHistorico());
                JOptionPane.showMessageDialog(null, "Tratamento registrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Pet não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar tratamento: " + e.getMessage());
        }
    }

    // Métodos de Visualização
    private static void visualizarUsuario() {
        try {
            int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("ID do Usuário:"));
            Usuario usuario = usuarioDAO.buscarUsuarioPorId(idUsuario);

            if (usuario != null) {
                JOptionPane.showMessageDialog(null, usuario.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao visualizar usuário: " + e.getMessage());
        }
    }

    private static void visualizarPet() {
        try {
            int idPet = Integer.parseInt(JOptionPane.showInputDialog("ID do Pet:"));
            Pet pet = petDAO.buscarPetPorId(idPet);

            if (pet != null) {
                JOptionPane.showMessageDialog(null, pet.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Pet não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao visualizar pet: " + e.getMessage());
        }
    }

    private static void visualizarHistoricoMedico() {
        try {
            int idPet = Integer.parseInt(JOptionPane.showInputDialog("ID do Pet:"));
            Historico historico = historicoDAO.buscarHistoricoPorId(idPet);

            if (historico != null) {
                JOptionPane.showMessageDialog(null, historico.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Histórico não encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao visualizar histórico médico: " + e.getMessage());
        }
    }
}
