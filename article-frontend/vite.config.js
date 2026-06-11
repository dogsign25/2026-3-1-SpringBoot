import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      // 경로가 /api로 시작하는 요청을 스프링 서버로 전달합니다.
      '/api': {
        target: 'http://localhost:8083', // 스프링 부트 서버 주소
        changeOrigin: true,
        secure: false,
        // 필요에 따라 /api 문자열을 제거하고 전달할 수 있습니다.
        // rewrite: (path) => path.replace(/^\/api/, '')
      }
    }
  }
})
