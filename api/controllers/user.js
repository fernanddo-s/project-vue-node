import db from "../db.js";

export const getUsers = (_, res) => {
    const q = "SELECT * FROM users";

    db.query(q, (err, data) => {
        if(err) return res.json(err);

        return res.status(200).json(data);
    });
};

export const addUser = (req, res) => {
    const q = "INSERT INTO users(nome,email,telefone,idade) VALUES (?)";

    const values = [
        req.body.nome,
        req.body.email,
        req.body.telefone,
        req.body.idade,
    ];

    db.query(q, [values], (err) => {
        if(err) return res.json(err);

        return res.status(200).json("Usuário cadastrado com sucesso!");
    });
};

export const updateUser = (req, res) => {
    const q = "UPDATE users SET `nome` = ?, `email` = ?, `telefone` = ?, `idade` = ? WHERE `id` = ?";

    const values = [
        req.body.nome,
        req.body.email,
        req.body.telefone,
        req.body.idade,
    ];

    db.query(q, [...values, req.params.id], (err) => {
        if(err) return res.json(err);

        return res.status(200).json("Usuário atualizado com sucesso!");
    });
};

export const getUser = (req, res) => {
    const q = "SELECT * FROM users WHERE `id` = ?";
    db.query(q, [req.params.id], (err, data) => {
        if(err) return res.json(err);

        return res.status(200).json(data);
    });
};

export const deleteUser = (req, res) => {
    const q = "DELETE FROM users WHERE `id` = ?";
    db.query(q, [req.params.id], (err) => {
        if(err) return res.json(err);

        return res.status(200).json("Usuário deletado com sucesso!");
    });
};