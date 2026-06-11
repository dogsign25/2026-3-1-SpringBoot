import { useState, useEffect } from 'react';
import axios from 'axios';
import { Routes, Route, Link } from "react-router-dom";
import Home from "./pages/Home";
import Notfound from "./pages/Notfound";
import ArticleList from './pages/ArticleList';
import ArticleWrite from './pages/ArticleWrite';

function App() {
  const [boards, setBoards] = useState([]);
  const [inputs, setInputs] = useState({ title: '', content: '' });
  const [editingId, setEditingId] = useState(null);
  const [refreshTick, setRefreshTick] = useState(0);

  useEffect(() => {
    axios.get('/api/articles').then((res) => setBoards(res.data));
  }, [refreshTick]);

  const triggerRefresh = () => setRefreshTick(prev => prev + 1);
  const onChange = (e) => setInputs({ ...inputs, [e.target.name]: e.target.value });

  const onSubmit = async () => {
    if (editingId) {
      await axios.patch(`/api/articles/${editingId}`, inputs);
      setEditingId(null);
    } else {
      await axios.post('/api/articles', inputs);
    }
    setInputs({ title: '', content: '' });
    triggerRefresh();
  };

  const onDelete = async (id) => {
    await axios.delete(`/api/articles/${id}`);
    triggerRefresh();
  };

  return (
    <div>
      <nav>
        <Link to={"/"}>[Home]</Link>
        <Link to={"/list"}>[게시판 목록]</Link>
        <Link to={"/write"}>[글쓰기]</Link>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/list" element={<ArticleList boards={boards} onDelete={onDelete} onEdit={(b) => setInputs({title: b.title, content: b.content}) || setEditingId(b.id)} />} />
        <Route path="/write" element={<ArticleWrite inputs={inputs} onChange={onChange} onSubmit={onSubmit} editingId={editingId} setEditingId={setEditingId} setInputs={setInputs} />} />
        <Route path="*" element={<Notfound />} />
      </Routes>
    </div>
  );
}

export default App;