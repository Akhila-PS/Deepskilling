import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            error: null
        };
    }

    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                this.setState({ posts: data });
            })
            .catch(error => {
                this.setState({ error: error.message });
            });
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        alert(`Error occurred: ${error.message}`);
        console.log(info);
    }

    render() {
        const { posts, error } = this.state;

        if (error) {
            return <h2 style={{ color: 'red' }}>Something went wrong: {error}</h2>;
        }

        return (
            <div>
                <h1>Blog Posts</h1>
                {posts.map(post => (
                    <Post 
                        key={post.id} 
                        title={post.title} 
                        body={post.body} 
                    />
                ))}
            </div>
        );
    }
}

export default Posts;